## avaliacoes-alunos

Projeto Java desenvolvido utilizando a tecnologia Hibernate (object-relational mapping), ferramenta que inspirou a especificação JPA.

* <b>Objetivo de aprendizado:</b> Criar as tabelas de Alunos, Avaliações, Respostas, Correções no banco de dados relacional utilizando a especificação JPA com Hibernate.

  * <b>Motivo da escolha:</b> Com o auxílio do Java Persistence API conseguimos nos afastar ao máximo mundo relacional, possibilitando trabalharmos apenas com objetos e focando mais na regra de negócio.

* Crio a base de dados onde o Hibernate irá criar minhas tabelas utilizando CREATE TABLE, comando necessário para criar novas tabelas.
* Configurar as informações necessárias para conexão com banco no arquivo persistence.xml no seguinte diretório: /projeto/resources/META-INF/persistence.xml
* Crio as classes com a anotação de que são entidades, que posteriormente serão criadas no banco de dados com os campos propostos no exercício:
    * Aluno (id, nome, email, idade)
  * Avaliações (id, titulo, descricao)
  * Correções (id, nota)
  * Respostas( id, solução, aluno, avaliação, correção)
* A entidade Repostas nos atributos aluno, avaliação, correção, configuro as anotações de cardinalidade, ou seja de que forma as tabelas irão se relacionar:
  * Aluno: @ManyToOne - N respostas para 1 aluno
  * Avaliação: @ManyToOne - N respostas para 1 avaliação
  * Correções: @OneToOne - 1 resposta para 1 correção
* Crio os getters and setters para todas as classes
* Todas as classes criadas anteriormente devo informar no meu arquivo persistence.xml
* Para salvar um Aluno crio uma classe CadastraAluno:
  * Abro um método main e dentro dele chamo o objeto EntityManagerFactory para passar as configurações de persistência.
  * Crio a entidade através do método createEntityManager do objeto EntityManagerFactory.
  * Instancio um objeto do tipo Aluno e setto as informações necessárias.
  * Para persistir o objeto abrimos uma transação, persistimos o objeto através do método do EntityManager e commitamos.
  * Fecha transação.
* Realizo esse mesmo procedimento para as entidades Avaliações e Correções. Exceto para de Respostas.
* Para salvar uma Resposta devo informar o id de um Aluno, Avaliação e Correção.
* Feito isso, ao executar os métodos criados acima as tabelas serão criadas automaticamente pelo Hibernate sem o mínimo de esforço e também será popular os dados requeridos.
* Para realizar a primeira consulta:
    * Crio uma classe BuscaCorrecaoPeloNomeAluno
    * Crio o objeto EntityManagerFactory e passo meu arquivo de configuração
    * Crio o objeto EntityManager através do método createEntityManager do objeto EntityManagerFactory
    * Crio uma seleção JPQL que seleciona os dados da tabela Correções pelo id
    * Instancio um objeto Aluno e setto o id desejado
    * Crio uma query tipada através do método createQuery do Entity Manager do tipo Resposta
    * Setto como parâmetro o id do Aluno instanciado acima
    * Com o resultado retornado da query do método getSingleResult, exibo nome do aluno retornado
* Para realizar a segunda consulta, repito os mesmo quase todos passos descritos acima, porém:
    * Realizo um getResultList para pegar um lista de respostas através do id do aluno
    * E faço um forEach para mapear todas as respostas respectivas daquele aluno.

* Resposta do Especialista:
    * Crio a classe Aluno, adiciono os atributos necessários e também adiciono um id. Adiciono o Id para mapear como chave primária para o banco de dados.
    * Mapeio a classe Aluno para ser entendida pelo HIbernate. Uso o @Entity em cima da classe e o @Id em cima do atributo id. Poderia colocar também o @Id no email. A @Entity explica para o Hibernate que aquela classe vai ser uma tabela no banco e o @Id explica que aquele atributo vai ser a chave primaria na tabela. Os outros atributos eu não preciso mapear pq ele já vai mapear para colunas do mesmo nome.
    * Crio a classe Avaliacao, adiciono os atributos necessários e também adiciono um id.
    * Mapeio a classe Avaliacao para ser entendida pelo HIbernate. Uso o @Entity em cima da classe e o @Id em cima do atributo id.
    * Crio a classe Resposta, adiciono os atributos necessários. Um dos atributos aqui é do tipo Avaliação, para fazer o link. Além disso adiciono o id. Uso o atributo do tipo Avaliacao para manter o domínio rico e tirar proveito do ORM.
    * Mapeio a classe Resposta para ser entendida pelo HIbernate. Uso o @Entity em cima da classe e o @Id em cima do atributo id. Além disso preciso usar o @ManyToOne em cima do atributo que representa a Avaliacao. Dessa forma o Hibernate vai entender que tal atributo precisa ser mapeado como chave estrangeira na tabela.
* Para salvar um aluno eu crio um EntityManagerFactory, construo um EntityManager, crio o objeto do tipo Aluno, abro uma transação, invoco o método persist e faço um commit. Preciso da EMF porque ela é a fábrica de EM. O EM representa a ideia de conexão com o banco de dados.
* Para salvar uma avaliacao eu crio um EntityManagerFactory, construo um EntityManager, crio o objeto do tipo Avaliacao, abro uma transação, invoco o método persist e faço um commit. Preciso da EMF porque ela é a fábrica de EM. O EM representa a ideia de conexão com o banco de dados. 
* Para salvar uma resposta eu crio um EntityManagerFactory, construo um EntityManager, carrego o objeto do tipo Avaliacao, carrego o objeto do tipo Aluno, crio o objeto do tipo Reposta, abro uma transação, invoco o método persist e faço um commit. Preciso da EMF porque ela é a fábrica de EM. O EM representa a ideia de conexão com o banco de dados. Preciso carregar os objetos do tipo Aluno e Avaliacao para construir o vínculo com a Resposta.
* Para salvar uma auto correcao eu crio um EntityManagerFactory, construo um EntityManager, carrego o objeto do tipo Resposta, crio o objeto do tipo AutoCorrecao, abro uma transação, invoco o método persist e faço um commit. Preciso da EMF porque ela é a fábrica de EM. O EM representa a ideia de conexão com o banco de dados. Preciso carregar o objeto do tipo Resposta para fazer o vínculo com a AutoCorrecao.
* Para descobrir o nome do(a) aluno(a) a partir da AutoCorrecao eu preciso navegar pelos relacionamentos @ManyToOne até chegar onde preciso. Isso pode ser feito através de métodos getters ou posso criar um método na AutoCorrecao que já me retorne o aluno em questão. 
* Para descobrir as respostas do aluno a partir do objeto do tipo Aluno é necessário ou fazer uma query planejada usando a JPQL. A ideia é realizar uma query sobre os objetos do tipo Resposta buscando todas que sejam daquele determinado(a) aluno(a). Algo como select r from Resposta r where r.aluno =:aluno .

