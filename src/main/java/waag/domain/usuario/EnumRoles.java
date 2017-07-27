package waag.domain.usuario;

public enum EnumRoles {
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	private String rol;
	
	EnumRoles(String rol){
		this.setRol(rol);
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
