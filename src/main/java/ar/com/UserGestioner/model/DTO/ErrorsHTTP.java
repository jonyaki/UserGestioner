package ar.com.UserGestioner.model.DTO;
import java.util.Date;
import java.util.List;

public class ErrorsHTTP {
	List<TypeErrorHTTP> error;

	public List<TypeErrorHTTP> getError() {
		return error;
	}

	public void setError(List<TypeErrorHTTP> error) {
		this.error = error;
	}

	public ErrorsHTTP(List<TypeErrorHTTP> error) {
		super();
		this.error = error;
	}
	
	
}
