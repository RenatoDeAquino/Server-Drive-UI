package com.example.firstexamplebff.screens

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import org.springframework.stereotype.Service


@Service
class Saque {
    val tela = Style(
            backgroundColor = "#1E477B",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 500.unitReal(), height = 350.unitReal()),

            margin = EdgeValue(top = 12.unitPercent()),
            padding = EdgeValue(all = 15.unitReal()),
            position = EdgeValue(0.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER,alignSelf = AlignSelf.CENTER),
            positionType = PositionType.RELATIVE,
            display = Display.FLEX

    )
    val botao1 = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 200.unitReal(), height = 50.unitReal()),
            positionType =PositionType.ABSOLUTE,
            margin = EdgeValue(left = 400.unitReal(),top = 250.unitReal()),
            flex = Flex(FlexDirection.ROW,/*justifyContent = JustifyContent.CENTER,*/alignItems = AlignItems.CENTER/*,alignSelf = AlignSelf.CENTER*/)
    )
    val botao2 = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 200.unitReal(), height = 50.unitReal()),
            positionType =PositionType.ABSOLUTE,
            margin = EdgeValue(left = 400.unitReal(),top = 400.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER/*,alignSelf = AlignSelf.CENTER*/)
    )

    val botao3 = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 200.unitReal(), height = 50.unitReal()),
            positionType =PositionType.ABSOLUTE,
            margin = EdgeValue(left = 400.unitReal(),top = 550.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER/*,alignSelf = AlignSelf.CENTER*/)
    )

    val botao4 = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 200.unitReal(), height = 50.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER/*,alignSelf = AlignSelf.CENTER*/),
            positionType = PositionType.ABSOLUTE,
            margin = EdgeValue(left = 1300.unitReal(),top = 250.unitReal())
    )

    val botao5 = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 200.unitReal(), height = 50.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER/*,alignSelf = AlignSelf.CENTER*/),
            positionType = PositionType.ABSOLUTE,
            margin = EdgeValue(left = 1300.unitReal(),top = 400.unitReal())
    )

    val botao6 = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 200.unitReal(), height = 50.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER/*,alignSelf = AlignSelf.CENTER*/),
            positionType = PositionType.ABSOLUTE,
            margin = EdgeValue(left = 1300.unitReal(),top = 550.unitReal())
    )
    fun withdraw_cash(): Screen = Screen(child = Container(children = listOf(
            Text(text =  "Quanto você deseja sacar?")
                    .applyStyle(style=tela),

            Button(text = "R$   10,00", onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/senha")
                    )
            )).applyStyle(style=botao1),
            Button(text = "R$   20,00", onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/senha")
                    )
            )).applyStyle(style=botao2),
            Button(text = "R$   50,00", onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/senha")
                    )
            )).applyStyle(style=botao3),
            Button(text = "R$   100,00", onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/senha")
                    )
            )).applyStyle(style=botao4),
            //Button(text = "Outro valor").applyStyle(style=botao5),
            Button(text = "Voltar",onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/homepage")
            ))).applyStyle(style = botao6)

    )))
}
