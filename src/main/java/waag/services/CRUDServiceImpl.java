package waag.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import waag.domain.entidades.Bulto;
import waag.domain.entidades.Buque;
import waag.domain.entidades.Cliente;
import waag.domain.entidades.Comisionista;
import waag.domain.entidades.Compvend;
import waag.domain.entidades.Destino;
import waag.domain.entidades.Operacion;
import waag.repositories.BultoRepository;
import waag.repositories.BuqueRepository;
import waag.repositories.ClienteRepository;
import waag.repositories.ComisionistaRepository;
import waag.repositories.CompvendRepository;
import waag.repositories.DestinoRepository;
import waag.repositories.OperacionRepository;

@Service
public class CRUDServiceImpl implements CRUDService {

	private static final Log LOG = LogFactory.getLog(CRUDServiceImpl.class);

	@Autowired
	private DestinoRepository destinoRepository;
	@Autowired
	private BuqueRepository buqueRepository;
	@Autowired
	private BultoRepository bultoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ComisionistaRepository comisionistaRepository;
	@Autowired
	private CompvendRepository compvendRepository;
	@Autowired
	private OperacionRepository operacionRepository;


	// +++ DESTINO +++
	@Override
	public Iterable<Destino> listAllDestinos() {
		return destinoRepository.findAllByOrderByCiudadAsc();
	}
	@Override
	public Page<Destino> listAllDestinosByPage(Pageable pageable) {
		return destinoRepository.findAllByOrderByCiudadAsc(pageable);
	}
	@Override
	public Destino getDestinoById(Integer id) {
		return destinoRepository.findOne(id);
	}
	@Override
	public Destino saveDestino(Destino destino) {
		return destinoRepository.save(destino);
	}
	@Override
	public void deleteDestino(Integer id) {
		destinoRepository.delete(id);
	}

	// +++ BUQUE +++
	@Override
	public Iterable<Buque> listAllBuques() {
		return buqueRepository.findAllByOrderByNombreAsc();
	}
	@Override
	public Page<Buque> listAllBuquesByPage(Pageable pageable) {
		return buqueRepository.findAllByOrderByNombreAsc(pageable);
	}
	@Override
	public Buque getBuqueById(Integer id) {
		return buqueRepository.findOne(id);
	}
	@Override
	public Buque saveBuque(Buque buque) {
		return buqueRepository.save(buque);
	}
	@Override
	public void deleteBuque(Integer id) {
		buqueRepository.delete(id);
	}

	// +++ BULTO +++
	@Override
	public Iterable<Bulto> listAllBultos() {
		return bultoRepository.findAllByOrderByTipoAsc();
	}
	@Override
	public Page<Bulto> listAllBultosByPage(Pageable pageable) {
		return bultoRepository.findAllByOrderByTipoAsc(pageable);
	}
	@Override
	public Bulto getBultoById(Integer id) {
		return bultoRepository.findOne(id);
	}
	@Override
	public Bulto saveBulto(Bulto bulto) {
		return bultoRepository.save(bulto);
	}
	@Override
	public void deleteBulto(Integer id) {
		bultoRepository.delete(id);
	}

	// +++ CLIENTE +++
	@Override
	public Iterable<Cliente> listAllClientes() {
		return clienteRepository.findAllByOrderByExportadorAsc();
	}
	@Override
	public Page<Cliente> listAllClientesByPage(Pageable pageable) {
		return clienteRepository.findAllByOrderByExportadorAsc(pageable);
	}
	@Override
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findOne(id);
	}
	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	@Override
	public void deleteCliente(Integer id) {
		clienteRepository.delete(id);
	}

	// +++ COMISIONISTA +++
	@Override
	public Iterable<Comisionista> listAllComisionistas() {
		return comisionistaRepository.findAllByOrderByComisionistaAsc();
	}
	@Override
	public Page<Comisionista> listAllComisionistasByPage(Pageable pageable) {
		return comisionistaRepository.findAllByOrderByComisionistaAsc(pageable);
	}

	@Override
	public Comisionista getComisionistaById(Integer id) {
		return comisionistaRepository.findOne(id);
	}

	@Override
	public Comisionista saveComisionista(Comisionista comisionista) {
		return comisionistaRepository.save(comisionista);
	}

	@Override
	public void deleteComisionista(Integer id) {
		comisionistaRepository.delete(id);
	}
	
	// +++ COMPVEND +++
	public Iterable<Compvend> listAllCompvends() {
		return compvendRepository.findAllByOrderByClienteAsc();
	}
	public Page<Compvend> listAllCompvendsByPage(Pageable pageable) {
		return compvendRepository.findAllByOrderByClienteAsc(pageable);
	}
	
	public Compvend getCompvendById(Integer id) {
		return compvendRepository.findOne(id);
	}
	public Compvend saveCompvend(Compvend compvend) {
		return compvendRepository.save(compvend);
	}
	public void deleteCompvend(Integer id) {
		compvendRepository.delete(id);
	}
	
	// +++ OPERACION +++
	public Iterable<Operacion> listAllOperaciones() {
		return operacionRepository.findAllByOrderByOperacionAsc();
	}
	public Page<Operacion> listAllOperacionesByPage(Pageable pageable) {
		return operacionRepository.findAllByOrderByOperacionAsc(pageable);
	}
	public Operacion getOperacionById(Integer id) {
		return operacionRepository.findOne(id);
	}
	public Operacion saveOperacion(Operacion operacion) {
		return operacionRepository.save(operacion);
	}
	public void deleteOperacion(Integer id) {
		operacionRepository.delete(id);
	}

}
