# Back end

O back end roda na porta 8080. Ele é composto por x endpoints:


### GET `/company/`
Retorna a lista de empresas com reclamações cadastradas no sistema.
### GET `/complaint/`
Retorna a lista geral de reclamações cadastradas no sistema.
### POST `/complaint/add/`
Cadastra uma reclamação no sistema.
### PUT `/complaint/edit`
Edita uma reclamação no sistema.
### DELETE `/complaint/del/{id}`
Deleta uma reclamação no sistema.
### GET `/complaint/ByCity/`
Retorna a lista de cidades que possuem reclamações cadastradas no sistema.
### GET `/complaint/ByCity/{nome-cidade}`
Retorna a quantidade de reclamações cadastradas na cidade, agrupado por empresa
### GET `/complaint/ByCompany/{id-company}`
Retorna a quantidade de reclamações sobre a empresa cadastradas, agrupado por cidade
### GET `/complaint/ByCompany/{id-company}/{nome-cidade}`
Retorna as reclamações que foram cadastradas sobre a empresa em determinada cidade.
