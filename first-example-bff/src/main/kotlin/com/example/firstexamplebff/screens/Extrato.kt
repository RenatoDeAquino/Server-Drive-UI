package com.example.firstexamplebff.screens

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import com.example.firstexamplebff.data.infos
import org.springframework.stereotype.Service


@Service


class Extrato {

    val button = Style(
            flex = Flex(alignSelf = AlignSelf.CENTER),
            margin = EdgeValue(all = UnitValue(0.8, type = UnitType.PERCENT))
    )

    val tela = Style(
            backgroundColor = "#1E477B",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 500.unitReal(), height = 350.unitReal()),
            margin = EdgeValue(top = 12.unitPercent()),
            padding = EdgeValue(all = 15.unitReal()),
            position = EdgeValue(0.unitReal()),
            flex = Flex(FlexDirection.COLUMN,justifyContent = JustifyContent.FLEX_START,alignItems = AlignItems.CENTER,alignSelf = AlignSelf.CENTER),
            positionType = PositionType.RELATIVE,
            display = Display.FLEX

    )

    fun extract(): Screen = Screen(child = Container(context = ContextData(id = "myContext", value = infos(nome = "@{myContext.infos.nome}", saldo = "@{myContext.infos.saldo}", extrato = "@{myContext.infos.extrato}")), children = listOf(
            Text(text =  "Extrato"),
            Button(text="Inserindo o cartão e digitando a senha", onPress = listOf(
                    SendRequest(
                            url = "http://localhost:4000",
                            method = RequestActionMethod.GET,
                            onSuccess = listOf(
                                    SetContext(
                                            contextId = "myContext",
                                            path = "infos",
                                            value = infos(
                                                    nome = "@{onSuccess.data.0.nome}",
                                                    saldo = "@{onSuccess.data.0.saldo}",
                                                    extrato = "@{onSuccess.data.0.extrato}"
                                            )

                                    )
                            )
                    )
            )),
            Text(text = "Nome: " + "@{myContext.infos.nome}"),
            Text(text = "Saldo: " + "@{myContext.infos.saldo}"),
            Text(text = "Extrato: " + "@{myContext.infos.extrato}"),

            Button("Voltar", onPress = listOf(
                Navigate.PushStack(
                    route = Route.Remote("/homepage"))
            )).applyStyle(style=button)
    )).applyStyle(style = tela))
}
