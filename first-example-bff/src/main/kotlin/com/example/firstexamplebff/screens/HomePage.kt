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
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import com.example.firstexamplebff.data.infos
import org.springframework.stereotype.Service

@Service
class HomePage {
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


    fun createScreen(): Screen = Screen(child = Container(context = ContextData(id = "myContext", value = infos(nome = "@{myContext.infos.nome}", saldo = "@{myContext.infos.saldo}", extrato = "@{myContext.infos.extrato}")), children = listOf(

            Button(text = "Saque", onPress = listOf(
                    Navigate.PushStack(
                        route = Route.Remote("/services/withdraw_cash")
                    ))).applyStyle(style = botao1),
            Button(text = "Depósito",onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/deposit")
                    ))).applyStyle(style = botao2),
            Button(text = "Extrato",onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/senhaextrato")
                    ))).applyStyle(style = botao3),
            Button(text = "Transferência",onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/transfer")
                    ))).applyStyle(style = botao4),
            Button(text = "Pagamento", onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/payment")
                    ))).applyStyle(style = botao5),
            Button(text = "Modificações de entrada",onPress = listOf(
                    Navigate.PushStack(
                            route = Route.Remote("/services/configs")
                    )
            )).applyStyle(style = botao6),
            Text(text = "bem vindo Mickey").applyStyle(style = tela)

    )))
}
