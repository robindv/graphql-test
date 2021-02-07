package example

import model.Student
import sangria.schema._

case class UpdateStudentGrades(studentid: String)

object GraphQLSchema {
  val students = List(
    Student("s1", "Robin de Vries"),
    Student("s2", "Student 2")
  )

  val StudentType = ObjectType(
    "Student",
    fields[Unit, Student](
      Field("id", StringType, resolve = _.value.id),
      Field("name", StringType, resolve = _.value.name)
    )
  )

  val QueryType = ObjectType("Query", fields[Unit, Unit](Field("students", ListType(StudentType), resolve = _ => students)))

  val StudentIdArg = Argument("studentid", StringType)

  val Mutation = ObjectType(
    "Mutation",
    fields[Unit, Unit](
      Field("updateStudentGrades", StudentType, arguments = StudentIdArg :: Nil, resolve = c => Student(c.arg(StudentIdArg), "Onbekend"))
    )
  )

  val schema: Schema[Unit, Unit] = Schema(QueryType, Some(Mutation))
}
