/*
 * Copyright © 2024 Алексей Каленчуков
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

public class Name
{
	/**
	 * Имя.
	 */
	@NotNull
	private final String value;

	/**
	 * Количество символов.
	 */
	private final int length;

	/**
	 * Рейтинг среди самых популярных имён в мире.
	 */
	private final int rank;

	/**
	 * Количество людей с этим именем в мире.
	 */
	private final int usage;

	/**
	 * Страна в которой большая плотность людей с этим именем.
	 */
	@NotNull
	private final String countryDensity;

//	/**
//	 * Страна в которой больше всего людей с этим именем.
//	 */
//	@NotNull
//	private final String countryPrevalent;

	public Name(@NotNull final String value, final int rank, final int usage, @NotNull final String countryDensity)
	{
		this.value = value;
		this.length = value.length();
		this.rank = rank;
		this.usage = usage;
		this.countryDensity = countryDensity;
	}

	@NotNull
	public String getValue()
	{
		return this.value;
	}

	public int getLength()
	{
		return this.length;
	}

	public int getRank()
	{
		return this.rank;
	}

	public int getUsage()
	{
		return this.usage;
	}

	@NotNull
	public String getCountryDensity()
	{
		return this.countryDensity;
	}

	public static Name of(@NotNull final String name, final int rank, final int usage, @NotNull final String countryDensity)
	{
		return new Name(name, rank, usage, countryDensity);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		Name name1 = (Name) obj;
		return Objects.equals(this.value, name1.value);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.value);
	}

	@NotNull
	@Override
	public String toString()
	{
		return "Name{" +
			"value='" + this.value + '\'' + ", " +
			"length=" + this.length + ", " +
			"rank=" + this.rank + ", " +
			"usage=" + this.usage + ", " +
			"countryDensity='" + this.countryDensity + '\'' +
			'}';
	}
}
