# deliveryclean
 API para previsão de gastos com combustível nas entregas
 
 ### Funcionalidades
 Cadastro de veículos (CRUD)
 Cálculo de previsão de gastos com combustível, ordenando por mais econômicos, levando em conta percurso da cidade e rodovias.
 
 ### Tecnologias
 
 Java 17
  Spring Boot 3
 Spring Data JPA
 H2 (Para teste)
  
### Documentação para teste
http://localhost:8080/swagger-ui/index.html

## Observação
Para facilitar um teste inicial, o sistema cadastra 2 veículos. Um mais econômico na cidade e o outro mais econômico na rodovia.
Reiniciando a aplicação os dados são apagados poruq eforam salvos em memória.
