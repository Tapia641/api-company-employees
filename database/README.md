```
docker build -t mysql-company-image .
```

```
docker run -d -p 3306:3306 --name mysql-company-container -e MYSQL_ROOT_PASSWORD=root_password -e MYSQL_USER=company_user -e MYSQL_PASSWORD=company_password mysql-company-image
```

```
docker exec -ti "ID OR NAME" bash
```

```
mysql -u USERNAME -p
mysql -u company_user -p
use bd_company
```

select r.region_id,r.region_name from region r;