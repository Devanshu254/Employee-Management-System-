import React from 'react'
import { NavLink } from 'react-router-dom'
import { isUserLoggedIn, logout } from '../services/AuthService'
import { useNavigate } from 'react-router-dom'
import toast from 'react-hot-toast'

const HeaderComponent = () => {

  const isAuth = isUserLoggedIn();

  const navigator = useNavigate();

  function handleLogout() {
    logout();
    const notify = () => toast.success('Logout Successfully');
    notify();
    navigator('/login')
  }

  return (
    <div>
        <header>
            <nav className='navbar navbar-expand-lg navbar-dark bg-dark'>
                <a className="navbar-brand" href="#">Employee Management System</a>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                      {
                        isAuth && 
                        <li className="nav-item">
                        <NavLink className='nav-link' to='/employees'>Employees</NavLink>
                      </li>
                      }
                      
                      {
                        isAuth && 
                        <li className="nav-item">
                        <NavLink className='nav-link' to='/departments'>Departments</NavLink>
                      </li>
                      }

                    </ul>
                </div>
                
                <ul className='navbar-nav'>
                  {
                    !isAuth &&
                    <li className='nav-item'>
                          <NavLink to="/register" className="nav-link">Register</NavLink>
                        </li>
                  }
                  {
                    !isAuth && 
                    <li className='nav-item'>
                          <NavLink to="/login" className="nav-link">Login</NavLink>
                        </li>
                  }

                  {
                    isAuth && 
                    <li className='nav-item'>
                          <NavLink to="/login" className="nav-link" onClick={handleLogout}>Logout</NavLink>
                        </li>
                  }
            
                    </ul>
            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent