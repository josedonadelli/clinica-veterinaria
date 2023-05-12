# Clinica Veterinária

Uma API de clínica veterinária que atende apenas cachorros
            

# Inicio do Rascunho
## Cadastro

### Como cadastrar um cliente
Para cadastrar um cliente, é necessário fornecer um nome de usuário (deve ser único) e senha, documento e nome do cliente, informações de contato, CEP (que será consumido pela API CEP) número e complemento (que não são fornecidos pela informação do CEP).

### Como cadastrar um veterinário 
Para cadastrar um veterinário, é necessário fornecer um nome de usuário (deve ser único) e senha, CRMV e nome do veterinário, informações de contato, CEP (que será consumido pela API CEP) número e complemento (que não são fornecidos pela informação do CEP).
### Como cadastrar um cachorro

Para cadastrar um cachorro, você DEVE vincular um tutor. Para isso, basta fornecer o documento do tutor desejado. E você DEVE informar o "idAPI" da raça. *
*Para buscar "idAPI" correto da raca do cachorro, basta ir na  Request "Buscar raca por nome", na pasta "Raça", e adicionar o inicio do nome da raca no final do endereco, depois de .../raca/ 
e.g.: {{baseUrl}}/cachorros/raca/pinscher
então e request retornará a(s) raça(s) correspondentes, com seus "idAPI".

## Consulta/Atendimento

### Como criar uma consulta
Para criar uma consulta, vá na pasta "Consulta" e na request "Criar uma consulta". Devem ser fornecidas as informações atuais do cachorro, como: peso, altura e idade. Também deve ser informado o veterinário, que será identificado pelo CRMV. Assim como o cliente, que será identificado pelo documento.
Deve ser preenchido o campo "Diagnóstico", com o parecer do veterinário, e, se necessário, o campo "Comentários"

### Como buscar uma consulta
#### Veterinário
Para os veterinários, é possível acessar toda e qualquer consulta, acessando as requests "Buscar todas as consultas" e "Buscar uma consulta". A segunda busca uma consulta específica pelo ID fornecido.

#### Cliente
Um cliente pode ter acesso às consultas de seus cachorros.
Na pasta "Clientes", acessar a request "Buscar consultas de um cachorro", fornecendo o documento do tutor, e o ID referente ao cachorro que se deseja visualizar as consultas.


### Exceeds

- Consumo da API de CEP
- Consumo da API de Cachorros para consulta de raça
- Consumo da API de Cachorros para buscar e salvar um cachorro no banco.
- Histórico de consultas: 
	Veterináro consegue acessar qualquer consulta	
	Cliente consegue acessar qualquer consulta que um cachorro ligado a ele tenha feito 
	
- Collection do postman na pasta raíz.
