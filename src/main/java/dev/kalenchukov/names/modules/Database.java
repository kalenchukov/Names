/*
 * Copyright © 2022-2025 Алексей Каленчуков
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

package dev.kalenchukov.names.modules;

import dev.kalenchukov.names.exceptions.DatabaseException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс базы данных.
 */
public class Database
{
	/**
	 * Название файла.
	 */
	@NotNull
	private static final String FILE = "names.db";

	/**
	 * Соединение.
	 */
	@Nullable
	private static Connection connection;

	/**
	 * Возвращает соединение.
	 *
	 * @return соединение.
	 */
	@NotNull
	public static Connection getConnection()
	{
		if (Database.connection == null) {
			try {
				DriverManager.registerDriver(new JDBC());
				Database.connection = DriverManager.getConnection("jdbc:sqlite::resource:" + FILE);
			} catch (SQLException exception) {
				throw new DatabaseException("Не удалось подключиться к базе данных.", exception);
			}
		}

		return Database.connection;
	}
}
