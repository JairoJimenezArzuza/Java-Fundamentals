# 🏢 Sistema de Gestión de Nómina (Payroll System)

Este proyecto es el primer módulo de mi laboratorio **Java-Fundamentals**. Consiste en un motor de cálculo de nómina que aplica los pilares de la Programación Orientada a Objetos (POO) y asegurando la integridad de los datos financieros.

## 🚀 Habilidades Aplicadas

* **Programación Orientada a Objetos:** Implementación de Abstracción, Herencia y Polimorfismo.
* **Manejo de Precisión:** Uso de `BigDecimal` para cálculos monetarios, evitando errores de redondeo de punto flotante.
* **Optimización de Memoria:** Uso de `StringBuilder` para la generación eficiente de reportes en consola.
* **Clean Code:** Aplicación de modificadores de acceso (`private`, `final`) y convenciones de nomenclatura profesional.
* **Testing:** Validación de lógica de negocio mediante pruebas unitarias automatizadas con JUnit 5.

## 🏗️ Estructura del Proyecto

El código se organiza en el paquete `com.jairo.poo.EmployeeManagementSystem` con la siguiente lógica:

| Clase | Función | Concepto de POO |
| :--- | :--- | :--- |
| **`Empleado`** | Clase abstracta que define el contrato base y atributos comunes (ID, Nombre, Departamento). | **Abstracción** |
| **`EmpleadoAsalariado`** | Implementación concreta para empleados con sueldo fijo mensual. | **Herencia** |
| **`EmpleadoPorHora`** | Implementación concreta para empleados con sueldo basado en las horas trabadas | **Herencia** |
| **`EmpleadoFreelancer`** | Implementación concreta para empleados que gana por proyecto entregado | **Herencia** |
| **`NominaService`** | Clase orquestadora que procesa la lista de empleados, valida reglas de negocio y genera el reporte total. | **Polimorfismo** |

## 🧪 Pruebas Unitarias (Unit Testing)

Para garantizar que el sistema es robusto, se implementaron tests con **JUnit 5** bajo el patrón **AAA (Arrange, Act, Assert)**:

1. **Cálculo de Nómina Exitoso:** Verifica que el reporte incluya los nombres de los trabajadores y el monto total correcto.
2. **Manejo de Errores (Excepciones):** Valida que el sistema lance una `IllegalArgumentException` si se detecta un salario negativo o inválido, protegiendo la lógica financiera de la aplicación.

## 🛠️ Tecnologías

* **Lenguaje:** Java 22
* **Gestor de Proyectos:** Maven
* **Testing:** JUnit 5.10.0
* **IDE:** NetBeans

---

### Cómo ejecutar este proyecto

1. Clona el repositorio.
2. Abre el proyecto como un proyecto Maven en tu IDE favorito.
3. Asegurase de encontrarse en la raiz del paquete `com.jairo.poo.EmployeeManagementSystem`
4. Para ejecutar las pruebas:
   * En NetBeans: `Alt + F6`.
   * En terminal: `mvn test`.

---
