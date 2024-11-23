# Software Testing Course Project

## Mutation Testing on Various Algorithms

This project aims to outline the implementation of mutation testing, specifically focusing on evaluating and improving the effectiveness of test cases in software projects. The project applies mutation testing techniques to make small changes to the code and assesses how well the existing test cases can detect these changes. By doing this, the project aims to identify gaps in the test cases, ensuring they are strong enough to catch potential errors and improve the overall quality of the software being tested..

---

## Steps to Perform Mutation Testing

### 1. Initialize the Project
- Use **Spring Initializr** to create a new **Spring Boot Project**.
- Configure the project with appropriate settings, such as project name, dependencies, and Java version.

### 2. Add Dependencies
- Include the necessary dependencies for **PITest** in the `pom.xml`.
- Refer to the official PITest website: [https://pitest.org/](https://pitest.org/) for the latest dependency information.


```xml  
<dependency>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
    <version>[latest-version]</version>
</dependency>
```


### 3. Develop the Codebase  
- Write the **core algorithms** that you want to test. Place them in the `src/main/java` directory of the project.  
- Create a **comprehensive test suite** in the `src/test/java` directory to ensure all edge cases are covered.  
- Write corresponding test classes for each algorithm to validate functionality. The test cases should address:  
  - **Typical Use Cases:** Test scenarios that represent expected and common inputs.  
  - **Edge Cases:** Test scenarios that cover boundary values, such as maximum or minimum inputs.  
  - **Invalid Inputs or Exceptions:** Test scenarios that handle improper inputs or errors gracefully.  

### 4. Prepare for Testing
- Before running mutation tests, ensure the project builds correctly and all existing test cases pass.
- Generate the target classes by executing the following command in the terminal:
  ```bash  
  mvn clean install  

### 5. Run Mutation Testing
- Use the PITest plugin to perform mutation testing and generate the mutation testing report by executing the following command:
  ```bash  
  mvn org.pitest:pitest-maven:mutationCoverage  

### 6. View the Mutation Report
- After running the mutation tests, the PITest plugin generates a report that can be accessed in the `target/pit-reports` directory.
- To view the report, follow these steps:
    1. Navigate to the `target/pit-reports` folder in your project directory.
    2. Open the `index.html` file in your web browser.
    3. The report will provide a detailed overview of mutation testing results, including:
        - **Mutation Coverage:** The percentage of mutations that were killed (detected by tests) versus survived (not detected).
        - **Detailed Mutation Information:** Specific code changes (mutations) and whether they were killed or survived.
        - **Test Effectiveness:** Insights into the quality of your test suite based on its ability to catch mutations.

- Use this report to analyze and refine your tests by identifying areas where test coverage can be improved.  


## Contributed By:

1. Abhipsa Panda (Abhipsa.Panda@iiitb.ac.in)
2. Himarishitha Reddy Kakunuri (Himarishitha.Kakunuri@iiitb.ac.in)


