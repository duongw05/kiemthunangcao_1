package buoi4.service;

import buoi4.model.Employee;
import buoi4.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public void add(Employee e){
        employees.add(e);
    }

    public List<Employee> getAll(){
        return employees;
    }

    public void update(Employee e,Integer id){
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).getId() == id){
                employees.set(i,e);
                return;
            }
        }
    }

    public void delete(Integer id){
        employees.removeIf(xe -> xe.getId() == id);
    }

    public Employee search(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
