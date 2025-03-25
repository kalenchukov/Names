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
Name{
    value='aleksey',
    length=7,
    rankWorld=154,
    rankCountry=0,
    usageWorld=3103214,
    usageCountry=0,
    origin='russian',
    continent='europe',
    country='',
    countryDensity='russia'
}
```

#### Возвращает список всех имён

```java
Names.getAll();
```

Результат выполнения:
```
[
	Name{
		value='roman',
		length=5,
		rankWorld=212,
		rankCountry=0, 
		usageWorld=2556570,
		usageCountry=0,
		origin='russian',
		continent='europe',
		country='',
		countryDensity='russia'
	},
	...
	Name{
		value='varenka',
		length=7,
		rankWorld=221036,
		rankCountry=0,
		usageWorld=1273,
		usageCountry=0,
		origin='russian',
		continent='europe',
		country='',
		countryDensity='russia'
	}
]
```

#### Возвращает список имён с большей плотностью использования в стране

```java
Names.getByCountryDensity("Russia");
```

Результат выполнения:
```
[
	Name{
		value='abidat',
		length=6,
		rankWorld=54308,
		rankCountry=0,
		usageWorld=11961,
		usageCountry=0,
		origin='avar',
		continent='europe',
		country='',
		countryDensity='russia'
	},
	...
	Name{
		value='zuran',
		length=5,
		rankWorld=182678,
		rankCountry=0,
		usageWorld=1757,
		usageCountry=0,
		origin='',
		continent='europe',
		country='',
		countryDensity='russia'
	}
]
```

#### Возвращает список имён по количеству людей с этим именем в мире

```java
Names.getBetweenUsageWorld(10000, 11000);
```

Результат выполнения:
```
[
	Name{
		value='melonie',
		length=7,
		rankWorld=61250,
		rankCountry=0,
		usageWorld=10000,
		usageCountry=0,
		origin='',
		continent='north america',
		country='',
		countryDensity='belize'
	}, 
	...
	Name{
		value='rahmatu',
		length=7,
		rankWorld=57465,
		rankCountry=0,
		usageWorld=11000,
		usageCountry=0,
		origin='',
		continent='africa',
		country='',
		countryDensity='nigeria'
	}
]
```

#### Возвращает список имён по рейтингу среди самых популярных имён в мире

```java
Names.getBetweenRankWorld(1, 5);
```

Результат выполнения:
```
[
	Name{
		value='maria',
		length=5,
		rankWorld=1,
		rankCountry=0,
		usageWorld=61134526,
		usageCountry=0,
		origin='italian',
		continent='europe',
		country='',
		countryDensity='andorra'
	},

	Name{
		value='muhammad',
		length=8,
		rankWorld=5,
		rankCountry=0,
		usageWorld=26397029,
		usageCountry=0,
		origin='arabic',
		continent='asia',
		country='',
		countryDensity='pakistan'
	}
]
```
