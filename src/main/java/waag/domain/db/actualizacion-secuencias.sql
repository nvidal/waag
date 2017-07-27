SELECT setval('bultos_seq', (SELECT max(idbulto) FROM bultos));
SELECT setval('buques_seq', (SELECT max(idbuque) FROM buques));
SELECT setval('clientes_seq', (SELECT max(idcliente) FROM clientes));
SELECT setval('comisionistas_seq', (SELECT max(idcomisionista) FROM comisionistas));
SELECT setval('compvend_seq', (SELECT max(idcompvend) FROM compvend));
SELECT setval('destinos_seq', (SELECT max(iddestino) FROM destinos));
SELECT setval('marcas_seq', (SELECT max(idmarca) FROM marcas));
SELECT setval('mediotransporte_seq', (SELECT max(idmedio) FROM mediotransporte));
SELECT setval('operaciones_seq', (SELECT max(codigo) FROM operaciones));
SELECT setval('mercaderias_seq', (SELECT max(idmercaderia) FROM mercaderias));
SELECT setval('estados_seq', (SELECT max(idestado) FROM estados));
SELECT setval('desccomercial_seq', (SELECT max(iddescripcion) FROM desccomercial));
SELECT setval('encargados_seq', (SELECT max(idencargado) FROM encargados));
SELECT setval('unidadcomercial_seq', (SELECT max(idunidad) FROM unidadcomercial));
--
SELECT setval('facturas_seq', (SELECT max(id) FROM facturas_aux));
