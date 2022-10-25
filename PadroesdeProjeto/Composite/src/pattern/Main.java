package pattern;
public class Main {
	public static void main(String args[]) {
		Departamento salesDepartment = new DepartamentoDeVendas(1, "Sales department");
		Departamento financialDepartment = new DepartamentoFinanceiro(2, "Financial department");
		ChefeDeDepartamento headDepartment = new ChefeDeDepartamento(3, "Head department");

		headDepartment.addDepartment(salesDepartment);
		headDepartment.addDepartment(financialDepartment);

		headDepartment.printDepartmentName();
	}
}