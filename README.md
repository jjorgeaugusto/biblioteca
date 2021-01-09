# Biblioteca
O projeto é uma demonstração de um sistema de bibliotecas. 

<br/>

## Funcionalidades:
<ul>
    <li>Receber doação de livro</li>
    <li>Emprestar livro</li> 
    <li>Receber doação</li>
</ul>

<br/>

## Dependências
<ul>
    <li>Docker</li>
    <li>Gradle</li>
    <li>java 11</li>
</ul>

<br/>

# Como executar o aplicativo
</br>

```
# Baixar imagem do banco de dados no DockerHub
docker pull mysql

# Criar novo container a partir da imagem do banco de dados MySQL
# Nesse comando também está incluso a criação do banco que a aplicação irá se conectar e configuração da senha do usuário root
docker run --name mymysql -p 3306:3306 -e MYSQL_DATABASE=biblioteca -e MYSQL_ROOT_PASSWORD=root -d mysql
 
# Criar jar da aplicação via Gradle
gradle jar

# Executar jar da aplicação para usa-la
java -jar build/libs/biblioteca-${versaoAtualDaAplicaçã}.jar
```


<br/>

## Tecnologias
<ul>
    <li>Linguagem: Java</li>
    <li>Gerenciador de dependências: Gradle</li>
    <li>Banco de dados: Mysql</li>
    <li>Virtualização: Docker</li>
</ul>