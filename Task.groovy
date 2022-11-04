
  class Task{
    String name
    String description
    Date dueDate
    boolean completed

    Task(String name,String desc,Date due,boolean comp){
      this.name = name
      this.description = desc
      this.dueDate = due
      this.completed = comp
    }

    @Override
    String toString(){
      "$name  $description ${completed ? "DONE!" : ""}\n$dueDate.format('MM/dd/yy')"
    }

    String ToCsv(){
      "$name,$description,$completed,$dueDate.format('MM/dd/yy')"
    }
  }
