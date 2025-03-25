/*
 * Copyright © 2022-2024 Алексей Каленчуков
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

package dev.kalenchukov.names.repositories;

import dev.kalenchukov.names.entities.Name;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Интерфейс для реализации репозитория имён.
 *
 * @author Алексей Каленчуков
 */
public interface NameRepositories
{
	/**
	 * Возвращает количество имён.
	 *
	 * @return количество имён.
	 */
	int count();

	/**
	 * Выполняет проверку существования имени.
	 *
	 * @param name имя.
	 * @return {@code true}, если имя существует, иначе {@code false}.
	 */
	boolean existsByName(@NotNull String name);

	/**
	 * Возвращает имя по названию.
	 *
	 * @param name имя.
	 * @return имя.
	 */
	@NotNull
	Name getByName(@NotNull String name);

	/**
	 * Возвращает список имён в указанной стране.
	 *
	 * @param country страна.
	 * @return список имён в указанной стране.
	 */
	@NotNull
	Collection<@NotNull Name> getByCountry(@NotNull String country);

	/**
	 * Возвращает список имён в указанной стране по плотности населения.
	 *
	 * @param country страна.
	 * @return список имён в указанной стране по плотности населения.
	 */
	@NotNull
	Collection<@NotNull Name> getByCountryDensity(@NotNull String country);

	/**
	 * Возвращает список всех имён.
	 *
	 * @return список всех имён.
	 */
	@NotNull
	Collection<@NotNull Name> getAll();

	/**
	 * Возвращает список имён по интервалу использования в мире.
	 *
	 * @param min минимальное количество использований.
	 * @param max максимальное количество использований.
	 * @return список имён.
	 */
	@NotNull
	Collection<@NotNull Name> getBetweenUsageWorld(int min, int max);

	/**
	 * Возвращает список имён по интервалу использования в стране.
	 *
	 * @param min минимальное количество использований.
	 * @param max максимальное количество использований.
	 * @return список имён.
	 */
	@NotNull
	Collection<@NotNull Name> getBetweenUsageCountry(int min, int max);

	/**
	 * Возвращает список имён по интервалу рейтинга в мире.
	 *
	 * @param min минимальное количество рейтинга.
	 * @param max максимальное количество рейтинга.
	 * @return список имён.
	 */
	@NotNull
	Collection<@NotNull Name> getBetweenRankWorld(int min, int max);

	/**
	 * Возвращает список имён по интервалу рейтинга в стране.
	 *
	 * @param min минимальное количество рейтинга.
	 * @param max максимальное количество рейтинга.
	 * @return список имён.
	 */
	@NotNull
	Collection<@NotNull Name> getBetweenRankCountry(int min, int max);

	/**
	 * Добавляет имя.
	 *
	 * @param name имя.
	 */
	void add(@NotNull Name name);

	/**
	 * Удаляет имя.
	 *
	 * @param name имя.
	 */
	void deleteByName(@NotNull String name);

	/**
	 * Создаёт таблицу для имён.
	 */
	void create();
}
