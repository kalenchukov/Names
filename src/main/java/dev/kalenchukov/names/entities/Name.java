/*
 * Copyright © 2024-2025 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.names.entities;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Класс имени.
 */
public final class Name
{
	/**
	 * Форма написания имени.
	 */
	@NotNull
	private final String value;

	/**
	 * Количество символов в имени.
	 */
	private final int length;

	/**
	 * Место среди самых популярных имён в мире.
	 */
	private final int rankWorld;

	/**
	 * Место среди самых популярных имён в стране.
	 */
	private final int rankCountry;

	/**
	 * Количество людей с этим именем в мире.
	 */
	private final int usageWorld;

	/**
	 * Количество людей с этим именем в стране.
	 */
	private final int usageCountry;

	/**
	 * Происхождение.
	 */
	@NotNull
	private final String origin;

	/**
	 * Континент использования.
	 */
	@NotNull
	private final String continent;

	/**
	 * Страна в которой больше всего людей с этим именем.
	 */
	@NotNull
	private final String country;

	/**
	 * Страна в которой больше всего плотность людей с этим именем.
	 */
	@NotNull
	private final String countryDensity;

	/**
	 * Конструктор для {@code Name}.
	 *
	 * @param value имя.
	 * @param rankWorld место среди самых популярных имён в мире.
	 * @param rankCountry место среди самых популярных имён в стране.
	 * @param usageWorld количество людей с этим именем в мире.
	 * @param usageCountry количество людей с этим именем в стране.
	 * @param origin происхождение.
	 * @param continent континент использования.
	 * @param country страна в которой больше всего людей с этим именем.
	 * @param countryDensity страна в которой больше всего плотность людей с этим именем.
	 */
	public Name(@NotNull final String value,
				final int rankWorld,
				final int rankCountry,
				final int usageWorld,
				final int usageCountry,
				@NotNull final String origin,
				@NotNull final String continent,
				@NotNull final String country,
				@NotNull final String countryDensity)
	{
		this.value = value;
		this.length = value.length();
		this.rankWorld = rankWorld;
		this.rankCountry = rankCountry;
		this.usageWorld = usageWorld;
		this.usageCountry = usageCountry;
		this.origin = origin;
		this.continent = continent;
		this.country = country;
		this.countryDensity = countryDensity;
	}

	/**
	 * Возвращает форму написания имени.
	 *
	 * @return имя.
	 */
	@NotNull
	public String getValue()
	{
		return this.value;
	}

	/**
	 * Возвращает количество символов в имени.
	 *
	 * @return количество символов в имени.
	 */
	public int getLength()
	{
		return this.length;
	}

	/**
	 * Возвращает место среди самых популярных имён в мире.
	 *
	 * @return место среди самых популярных имён в мире.
	 */
	public int getRankWorld()
	{
		return this.rankWorld;
	}

	/**
	 * Возвращает количество людей с этим именем в мире.
	 *
	 * @return количество людей с этим именем в мире.
	 */
	public int getUsageWorld()
	{
		return this.usageWorld;
	}

	/**
	 * Возвращает происхождение.
	 *
	 * @return происхождение.
	 */
	@NotNull
	public String getOrigin()
	{
		return this.origin;
	}

	/**
	 * Возвращает континент использования.
	 *
	 * @return континент использования.
	 */
	@NotNull
	public String getContinent()
	{
		return this.continent;
	}

	/**
	 * Возвращает страну в которой больше всего людей с этим именем.
	 *
	 * @return страна в которой больше всего людей с этим именем.
	 */
	@NotNull
	public String getCountry()
	{
		return this.country;
	}

	/**
	 * Возвращает страну в которой больше всего плотность людей с этим именем.
	 *
	 * @return страна в которой больше всего плотность людей с этим именем.
	 */
	@NotNull
	public String getCountryDensity()
	{
		return countryDensity;
	}

	/**
	 * Возвращает место среди самых популярных имён в стране.
	 *
	 * @return место среди самых популярных имён в стране.
	 */
	public int getRankCountry()
	{
		return this.rankCountry;
	}

	/**
	 * Возвращает количество людей с этим именем в стране.
	 *
	 * @return количество людей с этим именем в стране.
	 */
	public int getUsageCountry()
	{
		return this.usageCountry;
	}

	/**
	 * Создаёт имя.
	 *
	 * @param value имя.
	 * @param rankWorld место среди самых популярных имён в мире.
	 * @param rankCountry место среди самых популярных имён в стране.
	 * @param usageWorld количество людей с этим именем в мире.
	 * @param usageCountry количество людей с этим именем в стране.
	 * @param origin происхождение.
	 * @param continent континент использования.
	 * @param country страна в которой больше всего людей с этим именем.
	 * @param countryDensity страна в которой больше всего плотность людей с этим именем.
	 * @return имя.
	 */
	public static Name of(@NotNull final String value,
						  final int rankWorld,
						  final int rankCountry,
						  final int usageWorld,
						  final int usageCountry,
						  @NotNull final String origin,
						  @NotNull final String continent,
						  @NotNull final String country,
						  @NotNull final String countryDensity)
	{
		return new Name(value,
						rankWorld, rankCountry,
						usageWorld, usageCountry,
						origin,
						continent, country, countryDensity);
	}

	/**
	 * Проверяет равенство объектов.
	 *
	 * @param object сравниваемый объект.
	 * @return {@code true}, если объекты равны, иначе {@code false}.
	 */
	@Override
	public boolean equals(final Object object)
	{
		if (this == object)
		{
			return true;
		}
		if (object == null || getClass() != object.getClass())
		{
			return false;
		}
		Name name1 = (Name) object;
		return Objects.equals(value, name1.value);
	}

	/**
	 * Возвращает значение объекта в виде числа.
	 *
	 * @return число.
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return Objects.hashCode(value);
	}

	/**
	 * Возвращает значение объекта в виде строки.
	 *
	 * @return строку.
	 * @see Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Name{" +
			"value='" + this.value + '\'' + ", " +
			"length=" + this.length + ", " +
			"rankWorld=" + this.rankWorld + ", " +
			"rankCountry=" + this.rankCountry + ", " +
			"usageWorld=" + this.usageWorld + ", " +
			"usageCountry=" + this.usageCountry + ", " +
			"origin='" + this.origin + '\'' + ", " +
			"continent='" + this.continent + '\'' + ", " +
			"country='" + this.country + '\'' + ", " +
			"countryDensity='" + this.countryDensity + '\'' +
			'}';
	}
}
