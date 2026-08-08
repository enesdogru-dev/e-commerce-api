# 🛒 Mini E-Commerce REST API

Bu proje, modern Java backend geliştirme standartlarına uygun olarak tasarlanmış, **Spring Boot 3** ve **PostgreSQL (Docker)** altyapısını kullanan katmanlı bir REST API projesidir.

---

## 🛠️ Kullanılan Teknolojiler & Araçlar

* **Language:** Java 17
* **Framework:** Spring Boot 3
* **Database:** PostgreSQL (Docker konteyneri üzerinde)
* **ORM / Data Access:** Spring Data JPA / Hibernate
* **Boilerplate Reduction:** Lombok
* **Build Tool:** Maven
* **API Testing:** Postman

---

## 🏛️ Mimari Yapı (Layered Architecture)

Proje, yazılım dünyasında kabul görmüş **Separation of Concerns (Sorumlulukların Ayrılması)** prensibine uygun olarak katmanlı mimari ile inşa edilmiştir:

* `entity`: Veritabanı tablolarını (PostgreSQL) temsil eden JPA nesneleri (`Product`).
* `repository`: `JpaRepository` arabirimini kullanarak SQL yazmadan veritabanı işlemlerini gerçekleştiren katman (`ProductRepository`).
* `service`: İş kurallarının (Business Logic) ve kontrollerin yönetildiği beyin katmanı (`ProductService`).
* `controller`: Dış dünyaya (Frontend/Postman) JSON formatında cevap dönen REST uç noktaları (`ProductController`).

---

## 🚀 Projeyi Yerelde Çalıştırma Adımları

### 1. Veritabanını Docker Üzerinde Ayağa Kaldırma
Projenin ihtiyaç duyduğu PostgreSQL veritabanını Docker üzerinde çalıştırmak için terminalde şu komutu yürütün:

```bash
docker run --name postgres-db -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=ecommercedb -p 5432:5432 -d postgres
```

### 2. Uygulamayı Başlatma
IntelliJ IDEA üzerinden `ECommerceApiApplication.java` sınıfını çalıştırın. Uygulama varsayılan olarak `http://localhost:8080` portunda ayağa kalkacaktır.

---

## 📌 API Uç Noktaları (Endpoints)

### 1. Tüm Ürünleri Listeleme
* **HTTP Method:** `GET`
* **URL:** `http://localhost:8080/api/products`

### 2. Yeni Ürün Ekleme
* **HTTP Method:** `POST`
* **URL:** `http://localhost:8080/api/products`
* **Request Body (JSON):**

```json
{
  "name": "Mekanik Oyuncu Klavyesi",
  "description": "RGB Aydınlatmalı, Blue Switch",
  "price": 2450.00,
  "stock": 15
}
```

* **Response (200 OK / 201 Created):**

```json
{
  "id": 1,
  "name": "Mekanik Oyuncu Klavyesi",
  "description": "RGB Aydınlatmalı, Blue Switch",
  "price": 2450.00,
  "stock": 15
}
```

---

## 💡 Mimari & Mühendislik Kararları

* **Constructor Injection:** Bağımlılıkların enjeksiyonunda `@Autowired` yerine daha güvenli ve test edilebilir olan Yapıcı Metot Enjeksiyonu (Constructor Injection) tercih edilmiştir.
* **ORM & DDL Automation:** Hibernate'in `ddl-auto` özelliği sayesinde veritabanı şeması Java Entity sınıflarından otomatik olarak türetilmiştir.
