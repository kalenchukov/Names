# Справка
## Names
Получение информации об именах мира.

## Использование
#### Возвращает количество имён

```java
Names.count();
```

Результат выполнения:
```
12345678
```

#### Проверяет наличие имёни

```java
Names.exists("Aleksey");
```

Результат выполнения:
```
true
```

#### Возвращает информацию по имени

```java
Names.getByName("Aleksey");
```

Результат выполнения:
```
Name{value='aleksey', length=7, rank=154, usage=3103214, countryDensity='russia'}
```

#### Возвращает список имён используемых в стране

```java
Names.getCountry("Russia");
```

Результат выполнения:
```
[
	Name{value='yuliya', length=6, rank=329, usage=1908575, countryDensity='russia'},
	Name{value='maksim', length=6, rank=279, usage=2155370, countryDensity='russia'},
	Name{value='evgeniya', length=8, rank=1207, usage=781745, countryDensity='russia'},
	Name{value='evgeniy', length=7, rank=303, usage=2049441, countryDensity='russia'},
	Name{value='elena', length=5, rank=31, usage=8516023, countryDensity='russia'},
	Name{value='artem', length=5, rank=1222, usage=775076, countryDensity='russia'},
	Name{value='andzhela', length=8, rank=132074, usage=3003, countryDensity='russia'},
	Name{value='andey', length=5, rank=250393, usage=1027, countryDensity='russia'},
	...
	Name{value='aleksey', length=7, rank=154, usage=3103214, countryDensity='russia'}
]
```

#### Возвращает список всех имён

```java
Names.getAll();
```

Результат выполнения:
```
[
	Name{value='aadish', length=6, rank=421501, usage=416, countryDensity='iceland'},
	Name{value='aadim', length=5, rank=781395, usage=140, countryDensity='pakistan'},
	Name{value='aabir', length=5, rank=186675, usage=1696, countryDensity='morocco'},
	Name{value='aabhas', length=6, rank=486495, usage=325, countryDensity='luxembourg'},
	...
	Name{value='aabha', length=5, rank=99328, usage=4748, countryDensity='cayman islands'}
]
```

#### Возвращает список имён по количеству людей с этим именем

```java
Names.getBetweenUsage(10000, 100000);
```

Результат выполнения:
```
[
	Name{value='aagam', length=5, rank=616131, usage=215, countryDensity='india'},
	Name{value='aaftab', length=6, rank=74629, usage=7428, countryDensity='pakistan'},
	Name{value='aafiya', length=6, rank=271225, usage=897, countryDensity='maldives'},
	...
	Name{value='aadya', length=5, rank=624169, usage=210, countryDensity='mauritius'}
]
```

#### Возвращает список имён по рейтингу среди самых популярных имён

```java
Names.getBetweenRank(1, 100);
```

Результат выполнения:
```
[
	Name{value='aadhavan', length=8, rank=1566439, usage=42, countryDensity='malaysia'},
	Name{value='aadhav', length=6, rank=2523061, usage=19, countryDensity='malaysia'},
	Name{value='aadhar', length=6, rank=399588, usage=457, countryDensity='india'},
	Name{value='aadarsha', length=8, rank=1430306, usage=49, countryDensity='nepal'},
	...
	Name{value='aadab', length=5, rank=1068082, usage=81, countryDensity='denmark'}
]
```
