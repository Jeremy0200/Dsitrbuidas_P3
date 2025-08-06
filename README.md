# Dsitrbuidas_P3
# Proyecto Microservicios - Kubernetes + DockerHub

**Autores:** Alejandro Cuadrado, Isaac Escobar  
**Fecha:** 2025-08-06
---

## 🧱 Microservicios Desarrollados
- microservicio-central → PostgreSQL + RabbitMQ (puerto 8080)
- microservicio-facturacion → PostgreSQL + RabbitMQ (puerto 8081)
- microservicio-inventario → MongoDB + RabbitMQ (puerto 8082)
---
## 🐳 1. Subir imágenes a DockerHub
# Central
cd microservicio-central
docker build -t astarto/microservicio-central .
docker push astarto/microservicio-central

# Facturación
cd ../microservicio-facturacion
docker build -t astarto/microservicio-facturacion .
docker push astarto/microservicio-facturacion

# Inventario
cd ../microservicio-inventario
docker build -t astarto/microservicio-inventario .
docker push astarto/microservicio-inventario

# ☸️ 2. Desplegar en Kubernetes
# Iniciar Minikube
minikube start

# Crear bases de datos y mensajería
kubectl apply -f k8s/mongo-deployment.yaml
kubectl apply -f k8s/postgres-deployment.yaml
kubectl apply -f k8s/rabbitmq-deployment.yaml

# Desplegar microservicios
kubectl apply -f k8s/deployment-central.yaml
kubectl apply -f k8s/deployment-facturacion.yaml
kubectl apply -f k8s/deployment-inventario.yaml

Verifica con:

kubectl get pods
kubectl get services

## 📊 3. Visualizar en el Dashboard

minikube dashboard

Desde ahí podrás ver pods, servicios, deployments y volúmenes de forma gráfica.

## ✅ Notas

- Todas las imágenes se suben a DockerHub bajo el usuario `astarto`.
- Los puertos expuestos son internos en Kubernetes. Para acceso externo puedes usar `minikube service` o configurar un `Ingress`.
