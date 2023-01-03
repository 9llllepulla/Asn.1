/*
 * Copyright 2022 Sergey Lyashko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gllllepulla.plugin.formatter;

import com.gllllepulla.plugin.AsnLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AsnLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @Override
    public @NotNull Language getLanguage() {
        return AsnLanguage.INSTANCE;
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable customizable, @NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            customizable.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS");
            customizable.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Separator");
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            customizable.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
        }
    }

    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {
        return "Traps DEFINITIONS IMPLICIT TAGS ::= BEGIN\n" +
                "\n" +
                "EXPORTS trapMessage;\n" +
                "\n" +
                "IMPORTS TAGGED,\n" +
                "    sorm-message-trap FROM Classification,\n" +
                "    MessageID FROM Sorm;\n" +
                "\n" +
                "trapMessage TAGGED ::= {\n" +
                "    OID { sorm-message-trap }\n" +
                "    DATA CHOICE {\n" +
                "      trap [0]\tTrap,\t\t\t\t\t\t--- тип сообщения \"сигнал\"\n" +
                "      trap-ack [1]\tTrapAck\t\t\t\t\t\t--- тип сообщения \"подтверждение сигнала\"\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "-- Блок данных сообщения типа \"сигнал\"\n" +
                "Trap ::= SEQUENCE {\n" +
                "  trap-type \t\tTrapType,\t\t\t-- тип сообщения\n" +
                "  trap-message\t\tUTF8String (SIZE (1 .. 256)) OPTIONAL,\t-- описание сообщения\n" +
                "  reference-message\tMessageID OPTIONAL\t\t-- номер сообщение к которому относится данный сигнал \n" +
                "\t\t\t\t\t\t\t-- (например номер сообщения запросившего отчет при прерывании передачи)\n" +
                "}\n" +
                "\n" +
                "TrapType ::= ENUMERATED {\n" +
                "  heartbeat (0),\t\t\t\t-- тестовый пакет\n" +
                "  restart-software (1),\t\t\t-- перезапуск ПО\n" +
                "  unauthorized-access (2),\t\t\t-- попытка несанкционированного доступа\n" +
                "  critical-error (3),\t\t\t\t-- критическая ошибка ПО, потеря данных, дальнейшая работа невозможна\n" +
                "  major-error (4),\t\t\t\t-- серьезная ошибка ПО, потеря данных, но дальнейшая работа возможна\n" +
                "  minor-error (5)\t\t\t\t-- незначительная ошибка ПО, данные не потеряны, дальнейшая работа возможна\n" +
                "}\n" +
                "\n" +
                "-- Блок данных сообщения типа \"подтверждение сигнала\"\n" +
                "-- Номер сообщения TrapAck должен соответствовать номеру сообщения Trap\n" +
                "TrapAck ::= NULL\n" +
                "\n" +
                "END\n";
    }
}
