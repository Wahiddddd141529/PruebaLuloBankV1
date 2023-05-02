Feature: Actualizar Usuarios

  @UpdateUser
  Scenario: Actualizar un usario con la API dummyapi
    Given deseo actualizar usuarios por medio de la API
    When ejecute la peticion y visualice el usuario actualizado
    Then debe corresponder la informacion al usuario actualizada