package org.example;

class Task {
    private String name;
    private int priority;
    private Task next;

    public Task(String name, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Значение должно быть целое число от 1 до 5.");
        }
        this.name = name;
        this.priority = priority;
    }

    public void setNext(Task next) { this.next = next; }
    public Task getNext() { return next; }
    public String getName() { return name; }
    public int getPriority() { return priority; }
}

class TaskList {
    private Task head;

    public void add(String name, int priority) {
        Task newTask = new Task(name, priority);
        if (head == null) {
            head = newTask;
        } else {
            if (newTask.getPriority() < head.getPriority() || (newTask.getPriority() == head.getPriority() && newTask.getName().compareTo(head.getName()) < 0)) {
                newTask.setNext(head);
                head = newTask;
            } else {
                Task current = head;
                while (current.getNext() != null && (current.getNext().getPriority() < priority || (current.getNext().getPriority() == priority && current.getNext().getName().compareTo(newTask.getName()) < 0))) {
                    current = current.getNext();
                }
                newTask.setNext(current.getNext());
                current.setNext(newTask);
            }
        }
    }

    public void remove() {
        if (head != null) {
            if (head.getNext() == null) {
                head = null;
            } else {
                head = head.getNext();
            }
        }
    }

    public String toString()
    {
        Task t = head;
        String result = "";
        while (t != null)
        {
            result += t.getName() + "," + t.getPriority() + ";";
            t = t.getNext();
        }
        return result;
    }
}

class TaskManager {
    public static void main(String[] args) {
        System.out.println(manageTask("ADD,СделатьОтчет,4;ADD,ПровестиПрезентацию,2;ADD,НаписатьДокументацию,2;ADD,ОтправитьЧек,2;REMOVE;GET"));
        System.out.println(manageTask("REMOVE;ADD,КупитьПродукты,3;REMOVE;ADD,СделатьУборку,2;ADD,Постирать,5;ADD,Погладить,5;GET"));
        System.out.println(manageTask("ADD,ПосетитьВстречу,2;REMOVE;ADD,ПрочитатьГазету,1;REMOVE;GET"));
        System.out.println(manageTask("ADD,НаписатьКод,2;ADD,ТестироватьКод,3;ADD,ОтветитьНаСообщение,1;REMOVE;GET"));
    }

    public static String manageTask(String input) {
        String[] fullCommand = input.split(";");
        TaskList tm = new TaskList();
        String result = "";
        for (String c : fullCommand) {
            String[] shortCommand = c.split(",");
            switch (shortCommand[0].toUpperCase()) {
                case "ADD":
                    tm.add(shortCommand[1], Integer.parseInt(shortCommand[2]));
                    break;
                case "REMOVE":
                    tm.remove();
                    break;
                case "GET":
                    result += tm.toString();
                    break;
            }
        }
        return result.isEmpty() ? "Список пуст" : result.replaceAll(";$", "");
    }
}