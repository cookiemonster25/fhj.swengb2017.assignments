package at.fhj.swengb.apps.battleship.jfx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import scala.util.{Failure, Success, Try}

object BattleShipFxApp {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[BattleShipFxApp], args: _*)
  }

}


class BattleShipFxApp extends Application {

  val fxml = "/at/fhj/swengb/apps/battleship/jfx/battleshipfx.fxml"
  val css = "/at/fhj/swengb/apps/battleship/jfx/battleshipfx.css"

  val triedRoot = Try(FXMLLoader.load[Parent](getClass.getResource(fxml)))

  override def start(stage: Stage) = {
    triedRoot match {
      case Success(root) =>
        stage.setScene(new Scene(root))
        stage.show()
      case Failure(e) => e.printStackTrace()
    }
  }

}
