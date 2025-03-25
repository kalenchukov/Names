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

package dev.kalenchukov.names;

import dev.kalenchukov.names.entities.Name;
import dev.kalenchukov.names.repositories.NameRepositories;
import dev.kalenchukov.names.repositories.NameRepository;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Класс имён.
 *
 * @author Алексей Каленчуков.
 */
public final class Names
{
	/**
	 * Репозиторий имён.
	 */
	@NotNull
	private static final NameRepositories repository = new NameRepository();

	/**
	 * Конструктор для {@code Names}.
	 */
	private Names() {}

	/**
	 * Возвращает количество имён.
	 *
	 * @return количество имён.
	 */
	public static int count()
	{
		return repository.count();
	}

	/**
	 * Выполняет проверку существования имени.
	 *
	 * @param name имя.
	 * @return {@code true}, если имя существует, иначе {@code false}.
	 */
	public static boolean exists(@NotNull final String name)
	{
		return repository.existsByName(name);
	}

	/**
	 * Возвращает имя по названию.
	 *
	 * @param name имя.
	 * @return имя.
	 */
	@NotNull
	public static Name getByName(@NotNull final String name)
	{
		return repository.getByName(name);
	}

	/**
	 * Возвращает список имён в указанной стране.
	 *
	 * @param country страна.
	 * @return список имён в указанной стране.
	 */
	@NotNull
	public static Collection<@NotNull Name> getByCountry(@NotNull final String country)
	{
		return repository.getByCountry(country);
	}

	/**
	 * Возвращает список имён в указанной стране по плотности населения.
	 *
	 * @param country страна.
	 * @return список имён в указанной стране по плотности населения.
	 */
	@NotNull
	public static Collection<@NotNull Name> getByCountryDensity(@NotNull final String country)
	{
		return repository.getByCountryDensity(country);
	}

	/**
	 * Возвращает список всех имён.
	 *
	 * @return список всех имён.
	 */
	@NotNull
	public static Collection<@NotNull Name> getAll()
	{
		return repository.getAll();
	}

	/**
	 * Возвращает список имён по интервалу использования в мире.
	 *
	 * @param min минимальное количество использований.
	 * @param max максимальное количество использований.
	 * @return список имён.
	 */
	@NotNull
	public static Collection<@NotNull Name> getBetweenUsageWorld(final int min, final int max)
	{
		return repository.getBetweenUsageWorld(min, max);
	}

	/**
	 * Возвращает список имён по интервалу использования в стране.
	 *
	 * @param min минимальное количество использований.
	 * @param max максимальное количество использований.
	 * @return список имён.
	 */
	@NotNull
	public static Collection<@NotNull Name> getBetweenUsageCountry(final int min, final int max)
	{
		return repository.getBetweenUsageCountry(min, max);
	}

	/**
	 * Возвращает список имён по интервалу рейтинга в мире.
	 *
	 * @param min минимальное количество рейтинга.
	 * @param max максимальное количество рейтинга.
	 * @return список имён.
	 */
	@NotNull
	public static Collection<@NotNull Name> getBetweenRankWorld(final int min, final int max)
	{
		return repository.getBetweenRankWorld(min, max);
	}

	/**
	 * Возвращает список имён по интервалу рейтинга в стране.
	 *
	 * @param min минимальное количество рейтинга.
	 * @param max максимальное количество рейтинга.
	 * @return список имён.
	 */
	@NotNull
	public static Collection<@NotNull Name> getBetweenRankCountry(final int min, final int max)
	{
		return repository.getBetweenRankCountry(min, max);
	}
}
