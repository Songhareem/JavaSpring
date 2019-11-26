
# 과제

## 19/11/25

+ [X] LastName이 아니라 FirstName으로 검색
    + src/main/resources/templates/owners/findOwners.html 수정
        + th:field="*{lastName} => th:field="*{firstName}

    + src/main/java/org/springframework/samples/petclinic/owner/ownerController.java 수정
        + processFindForm 함수 내 수정
        + lastName => firstName으로 전부 교체

    + src/main/java/org/springframework/samples/petclinic/owner/ownerRepository.java 내에 함수 생성
        + @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.firstName LIKE %:firstName%")
        + @Transactional(readOnly = true)
        + Collection<Owner> findByFirstName(@Param("firstName") String firstName); 

+ [X] 정확히 일치하는게 아니라 해당 키워드가 들어있는거 찾기 (JPA 관련)
    + src/main/java/org/springframework/samples/petclinic/owner/ownerRepository.java 내에 생성한 함수 수정
    + @Query 에서, LIKE :firstName% => LIKE %:firstName% 로 수정

+ [X] Owner에 age 추가
    + src/main/java/org/springframework/samples/petclinic/owner/Owner.java 수정
        + private Integer age;
        + age getter/setter 추가
    
    + src/main/resources/db/hsqldb/schema.sql 수정
        + owners table 수정
        + age INTEGER 추가

    + src/main/resources/db/hsqldb/data.sql 수정
        + INSERT INTO owners VALUES 수정
        + age 값 추가
    
    + src/main/resources/templates/owners/createOrUpdateOwnerForm.html 수정
        + input age field 추가

    + src/main/resources/templates/owners/ownersList.html 수정
        + < th style="width: 150px;">Age< /th> 추가
        + < td th:text="${owner.age}"/> 추가

    + src/main/resources/templates/owners/ownerDetail.html 수정
        + < tr>
        + < th>Age< /th>
        + < td>< b th:text="*{age}">< /b>< /td>
        + < /tr> 추가
            
## 