Feature: Crear Usuario

  @CreateUser
  Scenario: Crear un usario con la API dummyapi
    Given deseo crear usuarios por medio de la API
    When ejecute la peticion y visualice el usuario creado
    Then debe corresponder la informacion al usuario creado

