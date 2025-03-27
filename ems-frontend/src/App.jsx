import './App.css'
import DepartmentComponent from './components/DepartmentComponent'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListDepartmentComponent from './components/ListDepartmentComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import RegisterComponent from './components/RegisterComponent'
import LoginComponenet from './components/LoginComponenet'
import { isUserLoggedIn } from './services/AuthService'
import {Toaster } from 'react-hot-toast';

function App() {
  
  function AuthenticatedRoute({children}) {
    const isAuth = isUserLoggedIn();
    if(isAuth) {
      return children;
    }
    return <Navigate to="/"/>
  }

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* // http://localhost:3000 */}
            <Route path='/' element={ <LoginComponenet /> }></Route>
            {/* // http://localhost:3000/employees */}
            <Route path='/employees' element={ 
              <AuthenticatedRoute>
                <ListEmployeeComponent />
              </AuthenticatedRoute>
            }></Route>
            {/* //http://localhost:3000/add-employee  */}
            <Route path='/add-employee' element = {
              <AuthenticatedRoute>
                <EmployeeComponent />
              </AuthenticatedRoute>
            }></Route>
            {/* //http://localhost:3000/edit-employee/1  */}
            <Route path='/edit-employee/:id' element = {
              <AuthenticatedRoute>
                <EmployeeComponent />
              </AuthenticatedRoute>
            }></Route>
            {/* //http://localhost:3000/departments  */}
            <Route path='/departments' element={ 
              <AuthenticatedRoute>
                <ListDepartmentComponent />
              </AuthenticatedRoute>
            }></Route>
            {/* //http://localhost:3000/add-department  */}
            <Route path='/add-department' element={ 
              <AuthenticatedRoute>
                <DepartmentComponent />
              </AuthenticatedRoute>
            }></Route>

            <Route path='/edit-department/:id' element={
              <AuthenticatedRoute>
                <DepartmentComponent />
              </AuthenticatedRoute>
              }></Route>
            {/* //http://localhost:3000/register  */}
            <Route path='/register' element={<RegisterComponent />}></Route>
            {/* //http://localhost:3000/login  */}
            <Route path='/login' element={<LoginComponenet />}></Route>
          </Routes>
        <FooterComponent />
        <Toaster />
      </BrowserRouter>
    </>
  )
}

export default App
