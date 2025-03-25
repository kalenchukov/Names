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
import dev.kalenchukov.names.exceptions.DatabaseException;
import dev.kalenchukov.names.exceptions.NameNotFoundException;
import dev.kalenchukov.names.modules.Database;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс репозитория имён.
 *
 * @author Алексей Каленчуков
 */
public class NameRepository implements NameRepositories
{
	/**
	 * Соединение с базой данных.
	 */
	@NotNull
	private final Connection connection;

	/**
	 * Конструктор для {@code NameRepository}.
	 */
	public NameRepository()
	{
		this.connection = Database.getConnection();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Name getByName(@NotNull final String name)
	{
		String sql = """
			SELECT * FROM `names` WHERE `name` = ? COLLATE NOCASE LIMIT 1
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setString(1, name);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			if (resultSet.next())
			{
				return Name.of(
					resultSet.getString("name"),
					resultSet.getInt("rank_world"),
					resultSet.getInt("rank_country"),
					resultSet.getInt("usage_world"),
					resultSet.getInt("usage_country"),
					resultSet.getString("origin"),
					resultSet.getString("continent"),
					resultSet.getString("country"),
					resultSet.getString("country_density")
				);
			}

			throw new NameNotFoundException("Имя '" + name + "' не найдено.");
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getAll()
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names`";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param country {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getByCountry(@NotNull final String country)
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names` WHERE `country` = ? COLLATE NOCASE";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setString(1, country);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param country {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getByCountryDensity(@NotNull final String country)
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names` WHERE `country_density` = ? COLLATE NOCASE";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setString(1, country);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getBetweenUsageWorld(final int min, final int max)
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names` WHERE `usage_world` NOT BETWEEN ? AND ?";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setInt(1, min);
			statement.setInt(2, max);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getBetweenUsageCountry(final int min, final int max)
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names` WHERE `usage_country` NOT BETWEEN ? AND ?";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setInt(1, min);
			statement.setInt(2, max);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getBetweenRankWorld(final int min, final int max)
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names` WHERE `rank_world` NOT BETWEEN ? AND ?";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setInt(1, min);
			statement.setInt(2, max);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param min {@inheritDoc}
	 * @param max {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public Collection<@NotNull Name> getBetweenRankCountry(final int min, final int max)
	{
		Collection<Name> names = new ArrayList<>();

		String sql = "SELECT * FROM `names` WHERE `rank_country` NOT BETWEEN ? AND ?";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setInt(1, min);
			statement.setInt(2, max);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next())
			{
				names.add(
					Name.of(
						resultSet.getString("name"),
						resultSet.getInt("rank_world"),
						resultSet.getInt("rank_country"),
						resultSet.getInt("usage_world"),
						resultSet.getInt("usage_country"),
						resultSet.getString("origin"),
						resultSet.getString("continent"),
						resultSet.getString("country"),
						resultSet.getString("country_density")
					)
				);
			}
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return names;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int count()
	{
		String sql = """
			SELECT COUNT(*) AS `count` FROM `names`
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			ResultSet resultSet = statement.getResultSet();
			resultSet.next();

			return resultSet.getInt("count");
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
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
		int count = 0;

		String sql = """
			SELECT COUNT(*) AS `count` FROM `names` WHERE `name` = ? COLLATE NOCASE LIMIT 1
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.execute();

			ResultSet resultSet = statement.getResultSet();
			resultSet.next();
			count = resultSet.getInt("count");
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}

		return (count != 0);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 */
	@Override
	public void deleteByName(@NotNull final String name)
	{
		String sql = """
			DELETE FROM `names` WHERE `name` = ? COLLATE NOCASE
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.execute();
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param name {@inheritDoc}
	 */
	@Override
	public void add(@NotNull final Name name)
	{
		String sql = """
			INSERT INTO names (name, length, rank_world, rank_country, usage_world, usage_country, origin, continent, country, country_density)
			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			""";

		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setString(1, name.getValue());
			statement.setInt(2, name.getLength());
			statement.setInt(3, name.getRankWorld());
			statement.setInt(4, name.getRankCountry());
			statement.setInt(5, name.getUsageWorld());
			statement.setInt(6, name.getUsageCountry());
			statement.setString(7, name.getOrigin());
			statement.setString(8, name.getCountry());
			statement.setString(9, name.getContinent());
			statement.setString(10, name.getCountryDensity());

			statement.execute();
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create()
	{
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE IF NOT EXISTS `names` (");
		sql.append("`id` INTEGER NOT NULL");

		sql.append(", `name` TEXT NOT NULL");
		sql.append(", `length` INTEGER NOT NULL");
		sql.append(", `rank_world` INTEGER NOT NULL");
		sql.append(", `rank_country` INTEGER NOT NULL");
		sql.append(", `usage_world` INTEGER NOT NULL");
		sql.append(", `usage_country` INTEGER NOT NULL");
		sql.append(", `origin` TEXT NOT NULL");
		sql.append(", `continent` TEXT NOT NULL");
		sql.append(", `country` TEXT NOT NULL");
		sql.append(", `country_density` TEXT NOT NULL");

		sql.append(", PRIMARY KEY(`id`)");
		sql.append(", UNIQUE(`name`)");
		sql.append(")");

		try (Statement statement = connection.createStatement())
		{
			statement.execute(sql.toString());
		}
		catch (SQLException exception)
		{
			throw new DatabaseException("Не удалось выполнить запрос в базу данных.", exception);
		}
	}
}
