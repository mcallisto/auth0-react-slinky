package demo.auth0react

import org.scalatest.funsuite.AnyFunSuite
import vision.id.auth0react.facade.auth0Auth0React.auth0Auth0ReactStrings

class Auth0ComponentTest extends AnyFunSuite {
  test("Auth0 String") {
    assert(auth0Auth0ReactStrings.LOGOUT === "LOGOUT")
  }

}
