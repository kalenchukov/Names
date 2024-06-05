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

package dev.kalenchukov.names;

import dev.kalenchukov.names.entities.Name;
import dev.kalenchukov.names.repositories.NameRepositories;
import dev.kalenchukov.names.repositories.NameRepository;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class Names
{
	@NotNull
	private static final NameRepositories repository = new NameRepository();

	public static int count()
	{
		return repository.count();
	}

	public static boolean exists(@NotNull final String name)
	{
		return repository.existsByName(name);
	}

	@NotNull
	public static Name getByName(@NotNull final String name)
	{
		return repository.getByName(name);
	}

	@NotNull
	public static Collection<@NotNull Name> getByCountry(@NotNull final String country)
	{
		return repository.getByCountry(country);
	}

	@NotNull
	public static Collection<@NotNull Name> getAll()
	{
		return repository.getAll();
	}

	@NotNull
	public static Collection<@NotNull Name> getBetweenUsage(final int min, final int max)
	{
		return repository.getBetweenUsage(min, max);
	}

	@NotNull
	public static Collection<@NotNull Name> getBetweenRank(final int min, final int max)
	{
		return repository.getBetweenRank(min, max);
	}
}
