# Web User List v1

Application that uses relational databases to manage users and their permissions on the website.

## Database

Build and run docker with a database instance
```courseignore
$ docker build -t webuserlist database/
$ docker run -p 3306:3306 -d webuserlist
```

## Development

Run development instance
```courseignore
$ mvn spring-boot:run
```

## Preview