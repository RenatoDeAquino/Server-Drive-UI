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
//import br.com.zup.beagle.widget.ui.TextInput
import org.springframework.stereotype.Service
//import java.awt.SystemColor.window

@Service
class SenhaExtrato {
    val style = Style(
            backgroundColor = "#1E477B",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 500.unitReal(), height = 500.unitReal()),

            margin = EdgeValue(top = 12.unitPercent()),
            padding = EdgeValue(all = 15.unitReal()),
            position = EdgeValue(0.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER,alignSelf = AlignSelf.CENTER),
            positionType = PositionType.RELATIVE,
            display = Display.FLEX
    )
    val buton = Style(
            backgroundColor = "#ff8100",
            cornerRadius = CornerRadius(25.0),
            size = Size(width = 530.unitReal(), height = 50.unitReal()),
            margin = EdgeValue(top = 0.5.unitPercent()),
            padding = EdgeValue(all = 15.unitReal()),
            position = EdgeValue(all = 0.unitReal()),
            flex = Flex(FlexDirection.ROW,justifyContent = JustifyContent.CENTER,alignItems = AlignItems.CENTER,alignSelf = AlignSelf.CENTER),
            positionType = PositionType.RELATIVE,
            display = Display.FLEX

    )
    fun createSenhaExtrato(): Screen = Screen(child = Container(children = listOf(
            Text(text = "Digite sua senha").applyStyle(style=style),
            Button(text = "Digitei minha senha", onPress = listOf(Navigate.PushStack(route = Route.Remote("/services/extract")))).applyStyle(style=buton)
            )
        )
    )
}