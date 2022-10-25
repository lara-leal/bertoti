package pattern;
public class DepartamentoDeVendas implements Departamento {

	private Integer id;
	private String name;

	public void printDepartmentName() {
		System.out.println(getClass().getSimpleName());
	}

	public DepartamentoDeVendas(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addDepartment(Departamento department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDepartment(Departamento department) {
		// TODO Auto-generated method stub
		
	}

	// standard constructor, getters, setters

}