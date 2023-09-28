# Utiliza la imagen oficial de MySQL
FROM mysql:latest

# Establece las variables de entorno para la contraseña de root y la base de datos
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=bd_company
ENV MYSQL_USER=company_user
ENV MYSQL_PASSWORD=company_password

# Copia el script SQL que contiene la estructura de la base de datos y los datos ficticios
COPY company.sql /docker-entrypoint-initdb.d/

# Expone el puerto MySQL
EXPOSE 3306
