package waag.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import waag.domain.entidades.Bulto;
import waag.domain.entidades.Buque;
import waag.domain.entidades.Cliente;
import waag.domain.entidades.Comisionista;
import waag.domain.entidades.Compvend;
import waag.domain.entidades.Destino;
import waag.domain.entidades.Operacion;;

public interface CRUDService {

	// +++ DESTINO +++ //
	Iterable<Destino> listAllDestinos();

	Destino getDestinoById(Integer id);

	Destino saveDestino(Destino destino);

	void deleteDestino(Integer id);

	// +++ BUQUE +++ //
	Iterable<Buque> listAllBuques();

	Page<Buque> listAllBuquesByPage(Pageable pageable);

	Buque getBuqueById(Integer id);

	Buque saveBuque(Buque buque);

	void deleteBuque(Integer id);

	// +++ BULTOS +++ //
	Iterable<Bulto> listAllBultos();

	Page<Bulto> listAllBultosByPage(Pageable pageable);

	Bulto getBultoById(Integer id);

	Bulto saveBulto(Bulto bulto);

	void deleteBulto(Integer id);

	// +++ CLIENTES +++ //
	Iterable<Cliente> listAllClientes();

	Cliente getClienteById(Integer id);

	Cliente saveCliente(Cliente cliente);

	void deleteCliente(Integer id);

	// +++ COMISIONISTA +++ //
	Iterable<Comisionista> listAllComisionistas();

	Comisionista getComisionistaById(Integer id);

	Comisionista saveComisionista(Comisionista comisionista);

	void deleteComisionista(Integer id);
	
	// +++ CLIENTES +++ //
	Iterable<Compvend> listAllCompvends();
	Compvend getCompvendById(Integer id);
	Compvend saveCompvend(Compvend compvend);
	void deleteCompvend(Integer id);
	
	// +++ OPERACIONES +++ //
	Iterable<Operacion> listAllOperaciones();
	Operacion getOperacionById(Integer id);
	Operacion saveOperacion(Operacion operacion);
	void deleteOperacion(Integer id);
}
