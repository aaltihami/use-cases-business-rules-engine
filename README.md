# use-cases-business-rules-engine


# Problem
When working with business projects with numerous use cases, each containing multiple business rules for validation, many developers choose to implementing these rules using nested if/else structures with try-catch blocks in between, produsing cluttered nested if/elses arrows everywhere. 
This approach results in code that is hard to read, understand, maintain, and developers are less likely to prefer working on such projects. 

![image](https://github.com/aaltihami/use-cases-business-rules-engine/assets/28863514/81d0aa92-60e3-478e-822f-bb8703f4e1a3)


# Proposed Solution  
This project offers a minimal business rules engine to organize business use cases and their related rules execution, ensuring readability and maintainability.
You will be able to : 
  - Create a usecase object per a business usecase.
  - Add a chain of business rules to the usecase, choose a clear class name for each business rule.
  - Manage each business rules seperately, adding, deleting and modifing business rules wont risk effecting athoer business rules.
  - Each business rule can recieve or share objects with other business rules through shareds Facts object per usecase.
  - Add one or more actions objects to be executed after passing all business rules validations.
  


