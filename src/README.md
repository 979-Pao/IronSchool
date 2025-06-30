
# 🎓 School Management System 🎓

Este proyecto en Java simula un sistema de gestión escolar, permitiendo registrar cursos, estudiantes, profesores, así como realizar operaciones de inscripción, asignación y consultas estadísticas.

---

## 📦 Estructura del Proyecto

```
src/
│
├── classes/
│   ├── Course.java
│   ├── Student.java
│   └── Teacher.java
│
├── test/
│   ├── CourseTest.java
│   ├── StudentTest.java
│   └── TeacherTest.java
│
│── Main.java
└── README.md
```

---

## 🛠️ Tecnologías utilizadas

- **Java**
- **JUnit**
- Terminal para entrada/salida (modo consola)

---

## 🚀 Cómo ejecutar el proyecto

1. Descarga el repositorio de GitHub.
2. Abre el proyecto con un editor de código, como por ejemplo, `IntelliJ`.
3. Abre el archivo `Main.java` e inicialo con **Run**

---

## 🧪 Pruebas Unitarias

El proyecto incluye pruebas con **JUnit** para validar el comportamiento de las clases principales.

Para ejecutarlas, asegúrate de tener JUnit configurado en tu entorno, como por ejemplo, `IntelliJ`.

Clases con pruebas:
- `CourseTest`: Validación de creación, asignación de profesor, ingreso de dinero, etc.
- `StudentTest`: Verificación de inscripción en cursos y cambio de curso.
- `TeacherTest`: Validación de datos del profesor.

---

## 🔵 Funcionalidades principales

### 🧩 Gestión de Entidades
- **👨🏻‍🏫 Profesor**: Nombre y salario.
- **📚 Curso**: Nombre, precio, profesor asignado, ganancias.
- **👤 Estudiante**: Nombre, dirección, correo electrónico, curso inscrito.

### 🧾 Comandos disponibles

- `ENROLL [STUDENT_ID] [COURSE_ID]`: Inscribir estudiante a un curso.
- `ASSIGN [TEACHER_ID] [COURSE_ID]`: Asignar profesor a un curso.
- `SHOW COURSES`: Lista de todos los cursos.
- `SHOW COURSES [TEACHER_ID]`: Cursos impartidos por un profesor.
- `SHOW STUDENTS`: Lista de todos los estudiantes.
- `SHOW STUDENTS [COURSE_ID]`: Estudiantes inscritos en un curso.
- `SHOW TEACHERS`: Lista de todos los profesores.
- `SHOW MONEY EARNED`: Total de dinero ganado por los cursos.
- `SHOW MONEY SPENT`: Total gastado en salarios.
- `SHOW STATS`: Estadísticas generales (ganancias, gastos, rentabilidad).
- `SHOW PROFIT`: Cálculo del beneficio neto.
- `LOOKUP COURSE [ID]`: Información detallada de un curso.
- `LOOKUP STUDENT [ID]`: Información de un estudiante.
- `LOOKUP TEACHER [ID]`: Información de un profesor.
- `EXIT`: Salir del sistema.

---

## ▶️ Ejemplo de ejecución

```

🏫 Enter the name of the school: IRONHACK

============================================================
  IRONHACK - SCHOOL MANAGEMENT SYSTEM 📚
============================================================
Welcome! You can manage teachers, courses and students from this system.

AVAILABLE COMMANDS
 - ENROLL [STUDENT_ID] [COURSE_ID]       -> Enroll student in a course
 - ASSIGN [TEACHER_ID] [COURSE_ID]       -> Assign teacher to a course
 - SHOW COURSES                          -> List all courses
 - SHOW COURSES [TEACHER_ID]             -> List courses taught by a teacher
 - SHOW STUDENTS                         -> List all students
 - SHOW STUDENTS [COURSE_ID]             -> List students in a specific course
 - SHOW TEACHERS                         -> List all teachers
 - SHOW MONEY EARNED                     -> Show total money earned from courses
 - SHOW MONEY SPENT                      -> Show total money spent on salaries
 - SHOW STATS                            -> Display school statistics
 - SHOW PROFIT                           -> Calculate school profit
 - LOOKUP COURSE [COURSE_ID]             -> View details of a course
 - LOOKUP STUDENT [STUDENT_ID]           -> View details of a student
 - LOOKUP TEACHER [TEACHER_ID]           -> View details of a teacher
 - EXIT                                  -> Exit the system
==============================

Enter number of teachers to create: 1

Enter details for Teacher 1:
👨🏻‍🏫 Name: John Smith
💰 Salary: 2000

Enter number of courses to create: 1

Enter details for Course 1:
📚 Name: Web Development
💶 Price: 500

Enter number of students to create: 1

Enter details for Student 1:
👤 Name: Kevin Taylor
🏠 Address: Street Test, 22
✉️ Email: kevin@test.com

You can now enter commands [ENROLL-ASSIGN-SHOW-LOOKUP]. Type 'EXIT' to quit.
> 
```

---

## ✅ Validaciones

- Los nombres de personas no pueden contener números.
- El correo electrónico debe tener un formato válido.
- No se permite ingresar números negativos.
- Los IDs se generan automáticamente para profesores, estudiantes y cursos.
- Las entradas mal formateadas son manejadas con mensajes de error amigables.

---

## 📈 Métricas y Estadísticas

El comando `SHOW STATS` incluye:

- Total de profesores, estudiantes y cursos.
- Ganancias totales.
- Salarios pagados.
- Rentabilidad (beneficio neto).
- Porcentaje de cursos con profesor asignado.