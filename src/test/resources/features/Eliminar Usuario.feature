Feature: Eliminar Usuario

  @DeleteUser
  Scenario: Eliminar usuario con la API dummyapi
    Given deseo elimnar un usuario por medio de la api
    When ejecute la peticion y elimine el usuario por medio del id
    Then se debe obtener el codigo de respuesta 200