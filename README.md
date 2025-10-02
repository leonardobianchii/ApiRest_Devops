# 📘 Projeto API REST - Deploy no Azure com ACR + ACI

Este guia explica como realizar o deploy da aplicação **ApiRest_Devops** e do banco de dados associado na **Azure**, utilizando:

- **Azure Resource Group (RG)**
- **Azure Container Registry (ACR)**
- **Azure Container Instance (ACI)**

A API será exposta publicamente para consumo e integrada com um banco MySQL rodando em container.  

---

## 📂 Estrutura do Projeto

- **ApiRest_Devops** → Projeto Java com API REST para gerenciar motos.
- **sql_mottu** → Scripts SQL + Dockerfile para container do banco MySQL.

---

## ⚡ Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- [Azure CLI](https://learn.microsoft.com/cli/azure/install-azure-cli)  
- [Docker](https://docs.docker.com/get-docker/)  
- [Git](https://git-scm.com/downloads)  

Além disso, você precisa estar logado na Azure CLI:

```bash
az login
```

---

## 🛠️ Passo a Passo do Deploy

### 1️⃣ Criar Resource Group

```bash
az group create --name rg-chalmottu --location eastus
```

---

### 2️⃣ Criar Container Registry (ACR)

```bash
az acr create \
  --resource-group rg-chalmottu \
  --name mottuacr558576 \
  --sku Standard \
  --location eastus \
  --public-network-enabled true \
  --admin-enabled true
```

---

### 3️⃣ Obter informações do ACR

```bash
# Endereço do ACR
az acr show --name mottuacr558576 --resource-group rg-chalmottu --query loginServer --output tsv

# Credenciais do ACR
az acr credential show --name mottuacr558576 --resource-group rg-chalmottu
```

⚠️ Exemplo de credenciais obtidas:
```json
"username": "mottuacr558576"
"password": "Or98Zmw/d67894RQkUcAk0GmUiNq9Q7zyQ+nJGDFkd+ACRDo2UyM"
```

---

### 4️⃣ Logar no ACR

```bash
az acr login --name mottuacr558576
```

---

### 5️⃣ Clonar repositórios

```bash
git clone https://github.com/leonardobianchii/ApiRest_Devops.git
git clone https://github.com/leonardobianchii/sql_mottu.git
```

---

### 6️⃣ Construir e enviar imagens para o ACR

#### API
```bash
cd ApiRest_Devops
docker build -t motu-api .
docker tag motu-api mottuacr558576.azurecr.io/motu-api:v1
docker push mottuacr558576.azurecr.io/motu-api:v1
```

#### Banco de Dados
```bash
cd ../sql_mottu
docker build -t motu-sql .
docker tag motu-sql mottuacr558576.azurecr.io/motu-sql:v1
docker push mottu-sql mottuacr558576.azurecr.io/motu-sql:v1
```

---

### 7️⃣ Conferir imagens no ACR

```bash
az acr repository list --name mottuacr558576 --output table
```

---

### 8️⃣ Criar Container do Banco (MySQL)

```bash
az container create \
  --resource-group rg-chalmottu \
  --name motu-sql \
  --image mottuacr558576.azurecr.io/motu-sql:v1 \
  --cpu 1 \
  --memory 1.5 \
  --ports 3306 \
  --os-type Linux \
  --environment-variables MYSQL_ROOT_PASSWORD=mottu123 MYSQL_DATABASE=mottuchal \
  --registry-username mottuacr558576 \
  --registry-password Or98Zmw/d67894RQkUcAk0GmUiNq9Q7zyQ+nJGDFkd+ACRDo2UyM
```

---

### 9️⃣ Criar Container da API

⚠️ Substitua `DB_HOST` pelo **IP público do container do banco**.

```bash
az container create \
  --resource-group rg-chalmottu \
  --name motu-api \
  --image mottuacr558576.azurecr.io/motu-api:v1 \
  --cpu 1 \
  --memory 1.5 \
  --ports 8080 \
  --os-type Linux \
  --ip-address Public \
  --environment-variables DB_HOST=4.156.197.7 DB_USER=root DB_PASSWORD=mottu123 DB_NAME=mottuchal \
  --registry-login-server mottuacr558576.azurecr.io \
  --registry-username mottuacr558576 \
  --registry-password Or98Zmw/d67894RQkUcAk0GmUiNq9Q7zyQ+nJGDFkd+ACRDo2UyM
```

---

## 🌐 Testando a API

A API estará disponível em:

```
http://20.241.140.250:8080/api/motos
```

### Exemplo de criação de motos (POST):

```json
{
  "id": 6,
  "placa": "ABC1A28",
  "modelo": {
    "id": 2,
    "nome": "Mottu-Express",
    "tipo": "Scooter"
  }
}
```

```json
{
  "id": 7,
  "placa": "ABC1A76",
  "modelo": {
    "id": 2,
    "nome": "Mottu-Express",
    "tipo": "Scooter"
  }
}
```

---

## ✅ Conclusão

Com esse passo a passo você terá:

- Banco de dados MySQL rodando em container no **ACI**  
- API Java rodando em container no **ACI**  
- Imagens armazenadas no **ACR**  
- Endpoint público disponível para consumo via Postman ou browser  

---

📌 Autores:
  **Leonardo Bianchi – RM 558576**     
  **Angello Turano da Costa - RM556511**  
  **Cauã Sanches de Santana - RM558317**        
📌 Projeto acadêmico FIAP – **DevOps & Cloud Computing**
