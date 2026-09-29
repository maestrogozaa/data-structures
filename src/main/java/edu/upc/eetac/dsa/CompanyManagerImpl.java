package main.java.edu.upc.eetac.dsa;

import java.util.*;

public class CompanyManagerImpl implements CompanyManager{

    private Map<String, Company> companies = new HashMap<>();
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void addCompany(String companyName, String description) {
        if(!companies.containsKey(companyName)){
            this.companies.put(companyName, new Company(companyName, description));
        }
    }

    @Override
    public void addEmployee(String name, String surname, Date birthday, double salary, String companyName) throws MyException {
        if (!this.companies.containsKey(companyName)) {
            throw new MyException();
        }

        this.employees.add(new Employee(name, surname, birthday, salary, companyName));
    }

    @Override
    public List<Employee> findAllEmployeesOrderedByName() {
        List<Employee> empleadosOrdenados = new ArrayList<>(this.employees);
        Comparator<Employee> comparadorPorNombre = (e1, e2) -> e1.getName().compareTo(e2.getName());
        empleadosOrdenados.sort(comparadorPorNombre);
        return empleadosOrdenados;
    }

    @Override
    public List<Employee> findAllEmployeesOrderedBySalary() {
        List<Employee> empleadosOrdenados = new ArrayList<>(this.employees);
        Comparator<Employee> comparadorPorSalario = Comparator.comparing(Employee::getSalary);
        empleadosOrdenados.sort(comparadorPorSalario);
        return empleadosOrdenados;
    }

    @Override
    public List<Employee> employees(String company) {
        List<Employee> empleadosCompania = new ArrayList<>();
        for(Employee e: this.employees){
            if(e.getCompanyName().equals(company)){
                empleadosCompania.add(e);
            }
        }
        return empleadosCompania;
    }

    @Override
    public List<Company> findAllCompanies() {
        return new ArrayList<>(this.companies.values());
    }
}
