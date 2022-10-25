package pattern;
import java.util.ArrayList;
import java.util.List;

public class ChefeDeDepartamento implements Departamento {
	private Integer id;
	private String name;

	private List<Departamento> childDepartments;

	public ChefeDeDepartamento(Integer id, String name) {
		this.id = id;
		this.name = name;
		this.childDepartments = new ArrayList<>();
	}

	public void printDepartmentName() {
		childDepartments.forEach(Departamento::printDepartmentName);
	}

	@Override
	public void addDepartment(Departamento department) {
		childDepartments.add(department);
	}

	@Override
	public void removeDepartment(Departamento department) {
		childDepartments.remove(department);
	}
}
