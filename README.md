# Dms Curd Operations

Crud operation for tables **DmsFieldMasterData, DmsFormConfig, and DmsSectionConfig**  
Used **Global Exception, Validations, Swagger UI, and Mappers**.  

## For Fields:
- **CreatedAt** → Used `LocalDateTime.now()`
- **UpdatedAt** → Used `LocalDateTime.now()`, which hits the DB only when **PUT** method is used.
