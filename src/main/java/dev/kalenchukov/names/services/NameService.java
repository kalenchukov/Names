/*
 * Copyright © 2025 Алексей Каленчуков
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

package dev.kalenchukov.names.services;

import dev.kalenchukov.names.entities.Name;
import dev.kalenchukov.names.repositories.NameRepositories;
import dev.kalenchukov.names.repositories.NameRepository;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Класс сервиса имён.
 *
 * @author Алексей Каленчуков
 */
public class NameService implements NameServices
{
	/**
	 * Репозиторий имён.
	 */
	@NotNull
	private static final NameRepositories repository = new NameRepository();

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int count()
	{
		return repository.count();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean existsByName(@NotNull final String name)
	{
		return repository.existsByName(name);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Name getByName(@NotNull final String name)
	{
		return repository.getByName(name);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param country {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getByCountry(@NotNull final String country)
	{
		return repository.getByCountry(country);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param country {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getByCountryDensity(@NotNull final String country)
	{
		return repository.getByCountryDensity(country);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getAll()
	{
		return repository.getAll();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getBetweenUsageWorld(final int min, final int max)
	{
		return repository.getBetweenUsageWorld(min, max);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getBetweenUsageCountry(final int min, final int max)
	{
		return repository.getBetweenUsageCountry(min, max);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getBetweenRankWorld(final int min, final int max)
	{
		return repository.getBetweenRankWorld(min, max);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<@NotNull Name> getBetweenRankCountry(final int min, final int max)
	{
		return repository.getBetweenRankCountry(min, max);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 */
	@Override
	public void add(@NotNull final Name name)
	{
		repository.add(name);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 */
	@Override
	public void deleteByName(@NotNull final String name)
	{
		repository.deleteByName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create()
	{
		repository.create();
	}
}
